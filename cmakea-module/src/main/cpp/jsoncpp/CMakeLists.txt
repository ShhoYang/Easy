cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_VERBOSE_MAKEFILE on)

add_library(
        jsoncpp
        STATIC
        src/json_reader.cpp
        src/json_tool.h
        src/json_value.cpp
        src/json_valueiterator.inl
        src/json_writer.cpp
        src/version.h.in)

set(export_dir ${CMAKE_CURRENT_SOURCE_DIR}/../../../../../export)

set_target_properties(
        jsoncpp
        PROPERTIES ARCHIVE_OUTPUT_DIRECTORY "${export_dir}/libajsoncpp/lib/${ANDROID_ABI}")

add_custom_command(
        TARGET jsoncpp POST_BUILD
        COMMAND "${CMAKE_COMMAND}" -E copy_directory "${CMAKE_CURRENT_SOURCE_DIR}/src/json" "${export_dir}/libajsoncpp/include/json/")