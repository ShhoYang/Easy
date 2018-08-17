package com.hao.easy.router.core.template;


import com.hao.easy.router.annotation.modle.RouteMeta;

import java.util.Map;

/**
 * @author Yang Shihao
 */
public interface IRouteGroup {
    void loadInto(Map<String,RouteMeta> atlas);
}
