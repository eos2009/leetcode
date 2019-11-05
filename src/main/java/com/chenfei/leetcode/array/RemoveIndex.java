package com.chenfei.leetcode.array;

/**
 * @author chenfei
 * @description 去掉一个数，如何让剩余的数乘积最大
 * @since 2019/10/28
 */
public class RemoveIndex {

    public static void main(String[] args) {
        int[] array1 = {-4, 3, -5, -7, -21, 9, -1, 5, 6};
        int index = findRemoveIndex(array1);
        System.out.println("删除元素下标：" + array1[index]);

        int[] array2 = {4, 3, 5, -7, -21, 9, -1, -5, 6, 0};
        index = findRemoveIndex(array2);
        System.out.println("删除元素下标：" + array2[index]);

        int[] array3 = {-4, -3, -5, -7, -21, -9, -1, -8};
        index = findRemoveIndex(array3);
        System.out.println("删除元素下标：" + array3[index]);
    }

    public static int findRemoveIndex(int[] array) {
        int negativeCnt = getNegativeCnt(array);
        // 奇数个负数
        if ((negativeCnt & 1) == 1) {
            return oddNegativeHandle(array);
        }
        // 偶数个负数，特殊情况（全是负数）
        if (negativeCnt == array.length) {
            return allNegativeHandle(array);
        }
        return evenNegativeHandle(array);
    }

    /**
     * 统计负数个数
     *
     * @param array
     * @return
     */
    public static int getNegativeCnt(int[] array) {
        int negativeCnt = 0;
        for (int ele : array) {
            if (ele < 0) {
                negativeCnt++;
            }
        }
        return negativeCnt;
    }

    /**
     * 奇数个负数
     *      删除最大负数
     *
     * @param array
     * @return
     */
    public static int oddNegativeHandle(int[] array) {
        int tempIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < 0) {
                if (array[tempIndex] < array[i]) {
                    tempIndex = i;
                }
            }
        }
        return tempIndex;
    }

    /**
     * 偶数个负数
     *      删除最小正数
     * @param array
     * @return
     */
    public static int evenNegativeHandle(int[] array) {
        int tempIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= 0) {
                if (array[tempIndex] > array[i]) {
                    tempIndex = i;
                }
            }
        }
        return tempIndex;
    }

    /**
     *  偶数个负数的特殊情况（全是负数）
     *      删除最小的负数
     * @param array
     * @return
     */
    public static int allNegativeHandle(int[] array) {
        int tempIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[tempIndex] > array[i]) {
                tempIndex = i;
            }
        }
        return tempIndex;
    }
}
