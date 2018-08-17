package com.hao.easy.router.core.exception;

/**
 * @author Yang Shihao
 */
public class NoRouteFoundException extends RuntimeException{

    public NoRouteFoundException(String message) {
        super(message);
    }
}
