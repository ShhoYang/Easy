package com.hao.easy.test;

import android.content.Context;

import com.hao.easy.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author Yang Shihao
 */
@RunWith(MockitoJUnitRunner.class)
public class MockUnitTest {

    private static final String FAKE_STRING = "AndroidUnitTest";

    @Mock
    Context context;

    @Test
    public void readStringFromContext_LocalizedString(){
        // 模拟getString()的返回值，隔离对Android系统的依赖,Mockito使用的是cglib的动态代理技术
        when(context.getString(R.string.app_name)).thenReturn(FAKE_STRING);
        assertThat(context.getString(R.string.app_name),is(FAKE_STRING));

        when(context.getPackageName()).thenReturn("com.hao.demo");
        System.out.println(context.getPackageName());

    }
}
