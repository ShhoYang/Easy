package com.hao.easy;

import android.app.Application;

/**
 * @author Yang Shihao
 */
public class Base {

   public static Application context;

   public static void init(Application application){
       context = application;
   }
}
