package com.hao.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * @author Yang Shihao‚
 * @date 2018/8/11
 */
@RunWith(MockitoJUnitRunner.class)
public class MyClassTest {

    @Mock  //注解实例
            MyClass mMyClass;

    @Test
    public void mockitoTestExample() {

        //调用getUniqueId()返回18
        when(mMyClass.getUniqueId()).thenReturn(18);

        //调用compareInt()传入任意值都返回19
        when(mMyClass.compareTo(anyInt())).thenReturn(19);

        //调用close()抛出NullPointerException
        doThrow(new NullPointerException()).when(mMyClass).close();

        //调用execute()什么都不做
        doNothing().when(mMyClass).execute();

        //getUniqueId()返回值是不是18
        assertThat(mMyClass.getUniqueId(),is(18));

        //验证getUniqueId()是不是只用了1次
        verify(mMyClass,times(1)).getUniqueId();

        //验证是不是没用过getUniqueId()
        //verify(mMyClass,never()).getUniqueId();

        //验证是否至少2次用过getUniqueId()
        verify(mMyClass,atLeast(1)).getUniqueId();

        //验证是否至多3次用过getUniqueId()
        verify(mMyClass,atMost(3)).getUniqueId();

        //验证是否使用过mMyClass.query("test string")
        mMyClass.query("test string");
        verify(mMyClass).query("test string");

        List list  = new LinkedList();
        //通过Mockito的spy()封装对象将其Mock的的spy对象
        List spy = spy(list);
        //指定spy.get(0)返回list0
        doReturn("list0").when(spy).get(0);

        assertEquals(spy.get(0),"list0");
    }
}