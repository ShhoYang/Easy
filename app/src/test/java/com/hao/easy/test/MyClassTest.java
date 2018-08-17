package com.hao.easy.test;

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

    //注解实例
    @Mock
    MyClass myClass;

    @Test
    public void mockitoTestExample() {

        //调用getUniqueId()返回18
        when(myClass.getUniqueId()).thenReturn(18);

        //调用compareInt()传入任意值都返回19
        when(myClass.compareTo(anyInt())).thenReturn(19);

        //调用close()抛出NullPointerException
        doThrow(new NullPointerException()).when(myClass).close();

        //调用execute()什么都不做
        doNothing().when(myClass).execute();

        //getUniqueId()返回值是不是18
        assertThat(myClass.getUniqueId(), is(18));

        //验证getUniqueId()是不是只用了1次
        verify(myClass, times(1)).getUniqueId();

        //验证是不是没用过getUniqueId()
        //verify(myClass,never()).getUniqueId();

        //验证是否至少2次用过getUniqueId()
        verify(myClass, atLeast(1)).getUniqueId();

        //验证是否至多3次用过getUniqueId()
        verify(myClass, atMost(3)).getUniqueId();

        //验证是否使用过myClass.query("test string")
        myClass.query("test string");
        verify(myClass).query("test string");

        List list = new LinkedList();
        //通过Mockito的spy()封装对象将其Mock的的spy对象
        List spy = spy(list);
        //指定spy.get(0)返回list0
        doReturn("list0").when(spy).get(0);

        assertEquals(spy.get(0), "list0");
    }
}