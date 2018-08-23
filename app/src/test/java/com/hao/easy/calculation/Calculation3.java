package com.hao.easy.calculation;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Yang Shihao
 *
 * 把数组内的奇数放左偶数放右
 *
 * 1, 2, 3, 4, 5, 6, 8, 7, 9, 10  -->  1, 9, 3, 7, 5, 6, 8, 4, 2, 10
 */
public class Calculation3 {

    @Test
    public void calculation() {
        int[] ints = {1, 2, 3, 4, 5, 6, 8, 7, 9, 10};
        int startIndex = 0;
        int endIndex = ints.length - 1;
        while (startIndex < endIndex) {
            int start = ints[startIndex];
            int end = ints[endIndex];
            if (isEven(start) && isOdd(end)) {
                ints[startIndex++] = end;
                ints[endIndex--] = start;

            } else if (isOdd(start)) {
                startIndex++;

            } else {
                endIndex--;
            }
        }

        for (int anInt : ints) {
            System.out.print(anInt + ", ");
        }
    }

    private boolean isOdd(int n) {
        return (n & 1) != 0;
    }

    private boolean isEven(int n) {
        return (n & 1) == 0;
    }
}
