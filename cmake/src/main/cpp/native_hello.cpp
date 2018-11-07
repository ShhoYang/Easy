
#include<jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_hao_easy_cmake_NativeFun_stringFromJNI(JNIEnv *env,jclass thiz){
    std::string hello = "Hello, I from C++";
    return env->NewStringUTF(hello.c_str());
}