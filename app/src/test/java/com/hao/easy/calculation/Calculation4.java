package com.hao.easy.calculation;

import org.junit.Test;

/**
 * @author Yang Shihao
 * <p>
 * 把数组内的奇数放左偶数放右，且保持原奇数组和偶数组的顺序不变
 * 1, 8, 3, 4, 5, 6, 2, 7, 9, 10  -->  1, 3, 5, 7, 9, 8, 4, 6, 2, 10
 */
public class Calculation4 {

    @Test
    public void calculation() {

        int[] ints = {1, 8, 3, 4, 5, 6, 2, 7, 9, 10};
        int length = ints.length;
        int index = 0;
        int evenCount = 0;
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            int anInt = ints[i];
            if (isEven(anInt)) {
                temp[evenCount] = anInt;
                evenCount++;
            } else {
                if (index < i) {
                    ints[index] = anInt;
                }
                index++;
            }
        }

        if(evenCount!=0){
            for (int i = index; i < length; i++) {
                ints[i] = temp[i-index];
            }
        }

        System.out.println();
        for (int anInt : ints) {
            System.out.print(anInt + ", ");
        }
    }

    private boolean isEven(int n) {
        return (n & 1) == 0;
    }
}
