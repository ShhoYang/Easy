package com.hao.easy.router.core.template;

import java.util.Map;

/**
 * @author Yang Shihao
 */
public interface IRouteRoot {

    void loadInto(Map<String,Class<? extends IRouteGroup>> routes);
}
