package com.hao.easy.router.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;

import com.hao.easy.router.annotation.Route;
import com.hao.easy.router.annotation.modle.RouteMeta;
import com.hao.easy.router.core.callback.NavigationCallback;
import com.hao.easy.router.core.exception.NoRouteFoundException;
import com.hao.easy.router.core.template.IRouteGroup;
import com.hao.easy.router.core.template.IRouteRoot;
import com.hao.easy.router.core.template.IService;
import com.hao.easy.router.core.utils.ClassUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

/**
 * @author Yang Shihao
 */
public class Router {

    private static final String TAG = "Router";
    private static final String ROUTE_ROOT_PACKAGE = "com.hao.easy.router.routes";
    private static final String CLASS_NAME_START = "Router_Root";

    private static Router instance;
    private static Application mContext;
    private Handler mHandler;

    private Router() {
        mHandler = new Handler();
    }

    public static Router getInstance() {
        if (instance == null) {
            synchronized (Route.class) {
                if (instance == null) {
                    instance = new Router();
                }
            }
        }
        return instance;
    }

    public static void init(Application application) {
        mContext = application;
        try {
            loadInfo();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "router初始化失败");
        }
    }

    private static void loadInfo() throws PackageManager.NameNotFoundException, InterruptedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获得所有 apt生成的路由类的全类名 (路由表)
        Set<String> routerMap = ClassUtils.getFileNameByPackageName(mContext, ROUTE_ROOT_PACKAGE);
        for (String className : routerMap) {
            //root中注册的是分组信息 将分组信息加入仓库中
            if (className.startsWith(ROUTE_ROOT_PACKAGE + "." + CLASS_NAME_START)) {
                ((IRouteRoot) Class.forName(className).getConstructor().newInstance()).loadInto(Warehouse.groupsIndex);
            }
        }

        for (Map.Entry<String, Class<? extends IRouteGroup>> stringClassEntry : Warehouse.groupsIndex.entrySet()) {
            Log.d(TAG, "Root映射表[ " + stringClassEntry.getKey() + " : " + stringClassEntry.getValue() + "]");

        }
    }

    public Postcard build(String path) {
        if (TextUtils.isEmpty(path)) {
            throw new RuntimeException("路由地址无效!");
        } else {
            return build(path, extractGroup(path));
        }
    }

    public Postcard build(String path, String group) {
        if (TextUtils.isEmpty(path) || TextUtils.isEmpty(group)) {
            throw new RuntimeException("路由地址无效!");
        } else {
            return new Postcard(path, group);
        }
    }

    /**
     * 获取组别
     */
    private String extractGroup(String path) {
        if (TextUtils.isEmpty(path) || !path.startsWith("/")) {
            throw new RuntimeException(path + " : 不能提取group.");
        }

        try {
            String defaultGroup = path.substring(1, path.indexOf("/", 1));
            if (TextUtils.isEmpty(defaultGroup)) {
                throw new RuntimeException(path + " : 不能提取group.");
            } else {
                return defaultGroup;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected Object navigation(Context context, final Postcard postcard, final int requestCode, final NavigationCallback callback) {
        try {
            prepareCard(postcard);
        } catch (NoRouteFoundException e) {
            e.printStackTrace();
            if (callback != null) {
                callback.onLost(postcard);

            }
            return null;
        }
        if (callback != null) {
            callback.onFound(postcard);
        }
        switch (postcard.getType()) {
            case ACTIVITY:
                final Context currentContext = context == null ? mContext : context;
                final Intent intent = new Intent(currentContext, postcard.getDestination());
                intent.putExtras(postcard.getExtras());
                int flags = postcard.getFlags();
                if (flags != -1) {
                    intent.setFlags(flags);
                } else if (!(currentContext instanceof Activity)) {
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (requestCode > 0) {
                            ActivityCompat.startActivityForResult((Activity) currentContext, intent, requestCode, postcard.getOptionsCompat());
                        } else {
                            ActivityCompat.startActivity(currentContext, intent, postcard.getOptionsCompat());
                        }

                        if(postcard.getEnterAnim()!=0 || postcard.getExitAnim()!=0 && currentContext instanceof Activity){
                            ((Activity)currentContext).overridePendingTransition(postcard.getEnterAnim(),postcard.getExitAnim());
                        }
                    }
                });
                break;
            case ISERVICE:
                return postcard.getService();
            default:
                break;
        }

        return null;
    }

    private void prepareCard(Postcard postcard) {
        RouteMeta routeMeta = Warehouse.routes.get(postcard.getPath());
        if (routeMeta == null) {
            Class<? extends IRouteGroup> groupMeta = Warehouse.groupsIndex.get(postcard.getGroup());
            if (groupMeta == null) {
                throw new NoRouteFoundException("没找到对应路由：分组=" + postcard.getGroup() + ", 路径=" + postcard.getPath());
            }

            IRouteGroup iRouteGroup;
            try {
                iRouteGroup = groupMeta.getConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("路由分组映射表记录失败.", e);
            }
            iRouteGroup.loadInto(Warehouse.routes);
            //已经准备过了就可以移除了 (不会一直存在内存中)
            Warehouse.groupsIndex.remove(postcard.getGroup());
            prepareCard(postcard);
        } else {
            postcard.setDestination(routeMeta.getDestination());
            postcard.setType(routeMeta.getType());
            switch (routeMeta.getType()) {
                case ISERVICE:
                    Class<?> destination = routeMeta.getDestination();
                    IService service = Warehouse.services.get(destination);
                    if (service == null) {
                        try {
                            service = (IService) destination.getConstructor().newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    postcard.setService(service);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 注入
     *
     * @param activity
     */
    public void inject(Activity activity) {
        Log.d(TAG, "inject: ");
        ExtraManager.getInstance().loadExtra(activity);
    }
}
