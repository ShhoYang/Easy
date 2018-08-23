package com.hao.easy.calculation;

import org.junit.Test;

/**
 * @author Yang Shihao
 * <p>
 * 一个数组中有一个元素出现的次数超过了数组长度的一半，找出这个元素
 */
public class Calculation7 {

    @Test
    public void calculation() {

        Object[] arr = {
                new TestObject("7"),
                new TestObject("9"),
                new TestObject("2"),
                new TestObject("2"),
                new TestObject("2"),
                new TestObject("6"),
                new TestObject("2"),
                new TestObject("6"),
                new TestObject("2"),
                new TestObject("2"),
                new TestObject("7"),
                new TestObject("2"),
                new TestObject("5")
        };

        int times = 1;
        Object result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (times == 0) {
                times = 1;
                result = arr[i];
            } else if (arr[i].equals(result)) {
                times++;
            } else {
                times--;
            }
            System.out.println(times + "\t" + result);
        }


        if (checkMoreThanHalf(arr, result)) {
            System.out.println(result.toString());
        } else {
            throw new IllegalArgumentException("not find the element");
        }
    }

    private boolean checkMoreThanHalf(Object[] arr, Object result) {
        int times = 0;
        for (Object o : arr) {
            if (o.equals(result)) {
                times++;
            }
        }
        return times * 2 > arr.length;
    }

    private static class TestObject {
        String unique;

        public TestObject(String unique) {
            this.unique = unique;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            TestObject testObject = (TestObject) obj;

            return unique != null ? unique.equals(testObject.unique) : testObject.unique == null;
        }

        @Override
        public int hashCode() {
            return unique == null ? 0 : unique.hashCode();
        }

        @Override
        public String toString() {
            return "TestObject{" +
                    "unique='" + unique + '\'' +
                    '}';
        }
    }
}
