package com.hao.easy.router.core.utils;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import com.hao.easy.router.core.thread.DefaultPoolExecutor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

import dalvik.system.DexFile;

/**
 * @author Yang Shihao
 */
public class ClassUtils {

    private static final String TAG = "ClassUtils";

    /**
     * 获得程序所有的apk(instant run会产生很多split apk)
     */
    private static List<String> getSourcePaths(Context context) throws PackageManager.NameNotFoundException {
        ApplicationInfo info = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        List<String> sourcePaths = new ArrayList<>();
        sourcePaths.add(info.sourceDir);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (null != info.splitSourceDirs) {
                sourcePaths.addAll(Arrays.asList(info.splitSourceDirs));
            }
        }
        return sourcePaths;
    }

    /**
     * 得到路由表的类名
     */
    public static Set<String> getFileNameByPackageName(Application context, final String packageName)
            throws PackageManager.NameNotFoundException, InterruptedException {
        final Set<String> classNames = new HashSet<>();
        List<String> paths = getSourcePaths(context);
        final CountDownLatch countDownLatch = new CountDownLatch(paths.size());
        ThreadPoolExecutor threadPoolExecutor = DefaultPoolExecutor.newDefaultPoolExecutor(paths.size());
        for (final String path : paths) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    DexFile dexFile = null;
                    try {
                        dexFile = new DexFile(path);
                        Enumeration<String>   entries = dexFile.entries();
                        while (entries.hasMoreElements()) {
                            String className = entries.nextElement();
                            if (!TextUtils.isEmpty(className) && className.startsWith(packageName)) {
                                classNames.add(className);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (dexFile != null) {
                            try {
                                dexFile.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        countDownLatch.countDown();
                    }
                }
            });
        }
        countDownLatch.await();
        return classNames;
    }
}
