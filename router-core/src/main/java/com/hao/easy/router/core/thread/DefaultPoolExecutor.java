package com.hao.easy.router.core.thread;

import android.support.annotation.NonNull;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Yang Shihao
 */
public class DefaultPoolExecutor {

    private static final ThreadFactory THREAD_FACTORY = new ThreadFactory() {

        private final AtomicInteger mCount = new AtomicInteger(1);

        @Override
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "Router #" + mCount.getAndIncrement());
        }
    };

    //核心线程和最大线程是cpu核心数+1
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int MAX_CORE_POOL_SIZE = CPU_COUNT + 1;
    //30秒回收线程
    private static final long SURPLUS_THREAD_LIST = 30L;

    public static ThreadPoolExecutor newDefaultPoolExecutor(int corePoolSize) {
        if (corePoolSize == 0) {
            return null;
        }

        corePoolSize = Math.min(MAX_CORE_POOL_SIZE, corePoolSize);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, corePoolSize,
                SURPLUS_THREAD_LIST, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(64),
                THREAD_FACTORY);
        //允许核心线程被销毁
        executor.allowCoreThreadTimeOut(true);
        return executor;

    }
}
