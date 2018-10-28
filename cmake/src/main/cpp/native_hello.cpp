//
// Created by hao on 2018/10/26.
//
#include<jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_hao_cmake_NativeFun_stringFromJNI(JNIEnv *env,jclass){
    std::string hello = "Hello, I from C++";
    return env->NewStringUTF(hello.c_str());
}