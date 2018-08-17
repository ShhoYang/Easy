package com.hao.easy.router.compiler.utils;

/**
 * @author Yang Shihao
 */
public class Constant {
    public static final String ACTIVITY = "android.app.Activity";
    public static final String ISERVICE = "com.hao.easy.router.core.template.IService";

    public static final String ARGUMENTS_NAME = "moduleName";
    /**
     * 需要处理的注解的路径
     */
    public static final String ANNOTATION_TYPE_ROUTE = "com.hao.easy.router.annotation.Route";

    /**
     * 生成类的超类的路径
     */
    public static final String IROUTE_GROUP = "com.hao.easy.router.core.template.IRouteGroup";
    public static final String IROUTE_ROOT = "com.hao.easy.router.core.template.IRouteRoot";

    /**
     * 生成代码的包名
     */
    public static final String PACKAGE_OF_GENERATE_FILE = "com.hao.easy.router.routes";

    /**
     * 生成代码的类名
     */
    public static final String NAME_OF_GROUP = "Router_Group_";
    public static final String NAME_OF_ROOT = "Router_Root_";

    /**
     * 生成代码的方法名
     */
    public static final String METHOD_LOAD_INTO = "loadInto";

}
