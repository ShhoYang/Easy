package com.hao.easy.calculation;

import org.junit.Test;

/**
 * @author Yang Shihao
 *
 * 单词和空格顺序反转
 * " yang shi hao"  -->  "hao shi yang "
 */
public class Calculation1 {

    @Test
    public void calculation() {
        String s = " yang shi hao";
        int length = s.length();
        char[] chars = reverse(s.toCharArray(), 0, length - 1);
        int start = 0;
        int end = 0;
        while (start < length) {
            if (chars[start] == ' ') {
                start++;
                end++;
            } else if (end == length || chars[end] == ' ') {
                //到结尾或者空格就反转前面的一个单词
                chars = reverse(chars, start, end - 1);
                start = end++;
            } else {
                end++;
            }
        }
    }

    /**
     * 反转
     */
    private char[] reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        System.out.println(new String(chars));
        return chars;
    }
}
