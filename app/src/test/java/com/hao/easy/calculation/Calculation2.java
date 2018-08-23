package com.hao.easy.calculation;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Yang Shihao
 *
 * 去掉首位空格，然后其它空格替换成20%
 * " yang shi hao "  -->  yang20%shi20%hao
 */
public class Calculation2 {

    @Test
    public void calculation() {
        String s = " yang shi hao ";
        String trimS = trim(s);
        int spaceCount = getSpaceCount(trimS);
        if (spaceCount == 0) {
            return;
        }

        int newLength = trimS.length() + 2 * spaceCount;
        char[] chars = trimS.toCharArray();
        char[] newChars = Arrays.copyOf(chars, newLength);
        int index = chars.length - 1;
        int newIndex = newChars.length - 1;
        while (index > 0 && newIndex > index) {
            if (newChars[index] == ' ') {
//                newChars[newIndex] = '%';
//                newChars[newIndex - 1] = '0';
//                newChars[newIndex - 2] = '2';
//                newIndex -= 3;

                newChars[newIndex--] = '%';
                newChars[newIndex--] = '0';
                newChars[newIndex--] = '2';

            } else {
                newChars[newIndex--] = newChars[index];
            }
            index--;
        }

        System.out.println(new String(newChars)); //yang20%shi20%hao
    }

    private String trim(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int start = 0;

        //前面有几个空格,如不是空格就结束while循环,start就是第一个不是空格的字符串的指针
        while (start < length && chars[start] == ' ') {
            start++;
        }

        System.out.println("start=" + start);

        //后面有几个空格,如不是空格就结束while循环,最小的指针要大于start,length就是最后一个不是空格的字符串的索引
        while (start < length && chars[length - 1] == ' ') {
            length--;
        }

        System.out.println("length=" + length);

        if (start > 0 || length < chars.length) {
            s = new String(chars, start, length - start);
        }

        System.out.println("s=" + s);

        return s;
    }

    private int getSpaceCount(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == ' ') {
                count++;
            }
        }
        return count;
    }

}
