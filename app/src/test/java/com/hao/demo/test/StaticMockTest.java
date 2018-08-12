package com.hao.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * @author Yang Shihao
 * @date 2018/8/11
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticClass1.class)
public class StaticMockTest {

    @Test
    public void testSomething() throws Exception {
        //mock完静态类后，默认所有的方法都不做任何事情
        mockStatic(StaticClass1.class);

        when(StaticClass1.getStaticMethod()).thenReturn("mock");
        StaticClass1.getStaticMethod();

        verifyStatic(StaticClass1.class,times(1));
    }
}
