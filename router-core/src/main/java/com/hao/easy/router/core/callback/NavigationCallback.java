package com.hao.easy.router.core.callback;

import com.hao.easy.router.core.Postcard;

/**
 * @author Yang Shihao
 */
public interface NavigationCallback {

    /**
     * 找到跳转页面
     */
    void onFound(Postcard postcard);

    /**
     * 未找到跳转页面
     */
    void onLost(Postcard postcard);

    /**
     * 跳转成功
     */
    void onArrival(Postcard postcard);
}
