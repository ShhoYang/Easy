package com.hao.easy.router_annotation.modle;


import javax.lang.model.element.Element;

import demo.hao.com.router_annotation.Route;

/**
 * @author Yang Shihao
 */
public class RouteMeta {

    public enum Type {
        ACTIVITY, SERVICE;
    }

    private Type mType;
    //节点
    private Element mElement;
    //使用的类对象
    private Class<?> mDestination;
    private String mPath;
    private String mGroup;

    public static RouteMeta build(Type type, Class<?> destination, String path, String group) {
        return new RouteMeta(type, null, destination, path, group);
    }

    public RouteMeta() {
    }

    public RouteMeta(Type type, Route route, Element element) {
        this(type, element, null, route.path(), route.group());
    }

    public RouteMeta(Type type, Element element, Class<?> destination, String path, String group) {
        mType = type;
        mElement = element;
        mDestination = destination;
        mPath = path;
        mGroup = group;
    }

    public Type getType() {
        return mType;
    }

    public void setType(Type type) {
        mType = type;
    }

    public Element getElement() {
        return mElement;
    }

    public void setElement(Element element) {
        mElement = element;
    }

    public Class<?> getDestination() {
        return mDestination;
    }

    public void setDestination(Class<?> destination) {
        mDestination = destination;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        mPath = path;
    }

    public String getGroup() {
        return mGroup;
    }

    public void setGroup(String group) {
        mGroup = group;
    }
}
