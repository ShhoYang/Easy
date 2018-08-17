package com.hao.easy.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;

import com.hao.easy.Base;

/**
 * @author Yang Shihao
 */
public class DisplayUtils {

    private static DisplayMetrics metrics;

    private DisplayUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static DisplayMetrics getDisplayMetrics() {
        if (metrics == null) {
            metrics = Base.context.getResources().getDisplayMetrics();
        }

        return metrics;
    }

    /**
     * 将px转换为dp值
     */
    public static int px2dip(float pxValue) {
        return (int) (pxValue / getDisplayMetrics().density + 0.5f);
    }

    /**
     * 将dp转换为px
     */
    public static int dip2px(float dipValue) {
        return (int) (dipValue * getDisplayMetrics().density + 0.5f);
    }

    /**
     * 将px转换为sp
     */
    public static int px2sp(float pxValue) {
        return (int) (pxValue / getDisplayMetrics().scaledDensity + 0.5f);
    }

    /**
     * 将sp转换为px
     */
    public static int sp2px(float spValue) {
        return (int) (spValue * getDisplayMetrics().scaledDensity + 0.5f);
    }

    /**
     * 获取屏幕宽度(px)
     */
    public static int getScreenWidth() {
        return getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕高度(px)
     */
    public static int getScreenHeight() {
        return getDisplayMetrics().heightPixels;
    }

    /**
     * 获取标题栏的高度
     */
    public int getActionBarHeight(Activity activity) {
        Rect rect = new Rect();
        Window window = activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        int statusBarHeight = rect.top;
        int contentViewTop = window.findViewById(Window.ID_ANDROID_CONTENT).getTop();
        int titleBarHeight = contentViewTop - statusBarHeight;
        return titleBarHeight;
    }

    /**
     * 获取状态栏高度
     */
    public static double getStatusBarHeight(Context context) {
        //获取status_bar_height资源的ID
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            return context.getResources().getDimensionPixelSize(resourceId);
        }
        return 0;
    }

    /**
     * 获取NavigationBar的高度
     */
    public static int getNavigationBarHeight(Context context) {
        if (!hasNavigationBar(context)) {
            return 0;
        }
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return resources.getDimensionPixelSize(resourceId);
        }
        return 0;
    }

    /**
     * 是否存在NavigationBar
     */
    public static boolean hasNavigationBar(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Display display = getWindowManager(context).getDefaultDisplay();
            Point size = new Point();
            Point realSize = new Point();
            display.getSize(size);
            display.getRealSize(realSize);
            return realSize.x != size.x || realSize.y != size.y;
        } else {
            boolean menu = ViewConfiguration.get(context).hasPermanentMenuKey();
            boolean back = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
            return !(menu || back);
        }
    }

    private static WindowManager getWindowManager(Context context) {
        return (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    }
}
