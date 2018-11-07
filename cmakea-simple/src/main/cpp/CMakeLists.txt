cmake_minimum_required(VERSION 3.4.1)

# 设置变量 找到存放资源的目录，".."代表上一级目录
set(export_dir ${CMAKE_SOURCE_DIR}/../../../../export)

# 添加.so动态库(jsoncpp)
add_library(
        lib_a_jsoncpp
        STATIC
        IMPORTED
)

# 链接
set_target_properties(
        # 库名字
        lib_a_jsoncpp
        # 库所在的目录
        PROPERTIES IMPORTED_LOCATION ${export_dir}/libajsoncpp/lib/${ANDROID_ABI}/libjsoncpp.a
)

add_library(
        native_hello
        SHARED
        native_hello.cpp
)

# 链接头文件
target_include_directories(
        native_hello
        PRIVATE
        # native_hello 需要的头文件
        ${export_dir}/libajsoncpp/include
)

# 链接项目中
target_link_libraries(
        native_hello
        android
        log
        # 链接 jsoncpp.a
        lib_a_jsoncpp
)