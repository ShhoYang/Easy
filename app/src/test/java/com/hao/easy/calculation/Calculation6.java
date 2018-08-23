package com.hao.easy.calculation;

import org.junit.Test;

/**
 * @author Yang Shihao
 * <p>
 * 一个整数数组中有一个数字出现的次数超过了数组长度的一半，找出这个数字
 */
public class Calculation6 {

    @Test
    public void calculation() {
        int[] arr = {2, 9, 2, 7, 2, 6, 5, 6, 2, 2, 7, 2, 2};
        sort(arr, 0, arr.length - 1);
        int middle = arr.length >> 1;
        int result = arr[middle];
        if (checkMoreThanHalf(arr, result)) {
            System.out.println(result);
        } else {
            new IllegalArgumentException("not find this number");
        }

    }

    public void sort(int[] arr, int head, int tail) {

        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }

        int i = head;
        int j = tail;
        // 取中间数为基准值
        int pivot = arr[(head + tail) / 2];
        while (i <= j) {
            // 处理大于等于基准数情况
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            // 直接互换，没有基准数归位操作
            if (i < j) {
                swap(arr, i, j);
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        // 递归处理基准数分隔的两个子数列。
        sort(arr, head, j);
        sort(arr, i, tail);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean checkMoreThanHalf(int[] arr, int result) {
        int times = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == result) {
                times++;
            }
        }
        return times * 2 > arr.length;
    }
}
