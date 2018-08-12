package com.hao.demo.test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yang Shihao
 * @date 2018/8/12
 */
public class FileDaoTest {

    FileDao mFileDao;

    @Before
    public void setUp() throws  Exception{
        mFileDao = new FileDao();
    }

    @Test
    public void testRead(){
        String  content = "hello android test";
        String name = "test.txt";
        System.out.println(mFileDao.getDirectory().getName());
        mFileDao.write(name,content);
        Assert.assertEquals(content,mFileDao.read(name));

    }
}
