package com.hao.demo.test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yang Shihao
 * @date 2018/8/12
 */
public class FileDaoTest {

    FileDao dao;

    @Before
    public void setUp() throws  Exception{
        dao = new FileDao();
    }

    @Test
    public void testRead(){
        String  content = "hello android test";
        String name = "test.txt";
        System.out.println(dao.getDirectory().getName());
        dao.write(name,content);
        Assert.assertEquals(content,dao.read(name));

    }
}
