package com.hao.easy.router_core.exception;

/**
 * @author Yang Shihao
 */
public class NoRouteFoundException extends RuntimeException{

    public NoRouteFoundException(String message) {
        super(message);
    }
}
