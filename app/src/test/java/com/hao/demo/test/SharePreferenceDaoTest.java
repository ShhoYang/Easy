package com.hao.demo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * @author Yang Shihao
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = RoboApp.class) // 配置Application
public class SharePreferenceDaoTest {

    private static final String TAG = "SharePreferenceDaoTest";

    private static final String KEY = "PRE_KEY";

    SharePreferenceDao dao;

    @Before
    public void setUp() {
        //这里就不用依赖其他库了，用RuntimeEnvironment.application代替Context
        dao = new SharePreferenceDao(RuntimeEnvironment.application);
    }

    @Test
    public void sharePreferenceDaoWriteRead() {
        dao.put(KEY, "123");
        String s = dao.get(KEY);
        System.out.println(s);
    }
}