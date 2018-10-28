package com.hao.cmake;

/**
 * @author Yang Shihao
 * @date 2018/10/26
 */
public class NativeFun {

    static {
        System.loadLibrary("native_hello");
    }

    public static native String stringFromJNI();
}
