package com.hao.easy.calculation;

import org.junit.Test;

/**
 * @author Yang Shihao
 * <p>
 * 输入一个整数数组，请写一个函数判断该数组是否是一棵二叉查找树的后序遍历序列
 */
public class Calculation11 {

    @Test
    public void calculation() {

        int[] array = {3, 7, 5, 9, 8, 12, 15, 13, 10};
        //int[] array = {3, 7, 5};

        System.out.println(isPostOrderArrayOfBST(array, 0, array.length));

    }

    private boolean isPostOrderArrayOfBST(int[] array, int start, int end) {
        if (array == null || array.length == 0 || start < 0 || end > array.length || start > end) {
            return false;
        }

        System.out.println(start + "-->" + end);

        if (end - start == 1) {
            return true;
        }

        int root = array[end - 1];

        int i = start;

        for (; i < end - 1; i++) {
            if (array[i] > root) {
                break;
            }
        }

        int j = i;
        for (; j < end - 1; j++) {
            if (array[j] < root) {
                return false;
            }
        }

        boolean left = true;
        if (i > 0) {
            left = isPostOrderArrayOfBST(array, start, i);
        }

        boolean right = true;
        if (i < end - 1) {
            right = isPostOrderArrayOfBST(array, i, end - 1);
        }

        return left && right;
    }
}