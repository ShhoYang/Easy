package com.hao.easy.calculation;

import org.junit.Test;

/**
 * @author Yang Shihao
 * <p>
 * 利用数组实现一个简易版的List，需要实现poll和push两个接口，
 * 前者为移除并获得队头元素，后者为向队尾添加一个元素，并能够自动扩容
 */
public class Calculation5 {

    @Test
    public void calculation() {
        CustomList<String> list = new CustomList<>();
        for (int i = 0; i < 30; i++) {
            list.push(i + "");
        }

        list.forEach();
        String poll = list.poll();
        System.out.println();
        //System.out.println(poll);
        list.forEach();
    }


    private class CustomList<T> {

        private static final int DEFAULT_CAPACITY = 8;
        private int size = 0;


        private Object[] arr;

        public CustomList() {
            arr = new Object[DEFAULT_CAPACITY];
        }

        public CustomList(int initCapacity) {
            if (initCapacity > 0) {
                arr = new Object[initCapacity];
            } else {
                arr = new Object[DEFAULT_CAPACITY];
            }
        }

        public T poll() {
            if (size == 0) {
                return null;
            } else {
                Object o = arr[0];
                System.arraycopy(arr, 1, arr, 0, size - 1);
                arr[--size] = null;
                return (T) o;
            }
        }

        public void push(T t) {
            if (size >= arr.length) {
                Object[] temp = arr;
                System.out.println();
                arr = new Object[temp.length + DEFAULT_CAPACITY];
                System.arraycopy(temp, 0, arr, 0, temp.length);
            }
            arr[size++] = t;
        }

        public void forEach() {
            for (Object o : arr) {
                System.out.print(o + ", ");
            }
        }
    }
}
