package com.hao.easy.test;


/**
 * @author Yang Shihao
 */
public class PhoneTest {
    public static boolean isPhone(String s){
        return s.length() ==11;
    }

    public static boolean isCard(String s){
        return s.matches("^[A-Za-z0-9]+$");
    }
}
