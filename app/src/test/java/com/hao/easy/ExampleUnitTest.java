package com.hao.easy;


import org.junit.Test;

import java.math.BigInteger;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void test() {
        //2147483647
        String s = "2444815874";
        int i = Integer.reverseBytes(new BigInteger(s).intValue());
        String s1 = String.format("%08x", i).toUpperCase();
        System.out.println(s1);
    }
}