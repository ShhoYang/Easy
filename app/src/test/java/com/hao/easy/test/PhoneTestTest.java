package com.hao.easy.test;

import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author Yang Shihao
 */
public class PhoneTestTest {

    @Test
    public void isPhone() {
        assertThat(PhoneTest.isPhone("15137174714"), is(true));
    }

    @Test
    public void isCard() {
        System.out.println(toHexCardNum("2444815874"));
    }

    private String toHexCardNum(String s) {
        int i1 = Integer.parseInt("02EEB891", 16);
        System.out.println(i1);
        BigInteger i = new BigInteger(s);
        long l = i.longValue();
        byte[] b = new byte[4];
        b[0] = (byte) (0xff & l);
        b[1] = (byte) ((0xff00 & l) >> 8);
        b[2] = (byte) ((0xff0000 & l) >> 16);
        b[3] = (byte) ((0xff000000 & l) >> 24);
        int x = ((b[0] & 0xFF) << 24) + ((b[1] & 0xFF) << 16) + ((b[2] & 0xFF) << 8) + 1;
        return Integer.toHexString(x).toUpperCase();
    }
}