package com.chenfei.leetcode.sort;

import java.util.Arrays;

/**
 * @author chenfei
 * @description 归并排序
 * @since 2019/10/9
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {5, 8, 6, 3, 9, 2, 1, 7};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 拆分-归并
     * @param array
     * @param start
     * @param end
     */
    private static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            // 折半成两个小集合,依次递归
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            // 把两个有序小集合,归并成一个大集合
            merge(array, start, mid, end);
        }
    }

    /**
     * 归并
     * @param array
     * @param start
     * @param mid
     * @param end
     */
    private static void merge(int[] array, int start, int mid, int end) {
        // 临时大集合
        int[] tempArr = new int[end - start + 1];
        int p1 = start;
        int p2 = mid + 1;
        int p = 0;
        //比较两个小集合元素，依次放入大集合
        while (p1 <= mid && p2 <= end) {
            if (array[p1] <= array[p2]) {
                tempArr[p++] = array[p1++];
            } else {
                tempArr[p++] = array[p2++];
            }
        }
        // 左侧小集合还有剩余,一次放入大集合尾部
        while (p1 <= mid) {
            tempArr[p++] = array[p1++];
        }
        // 右侧小集合还有剩余,一次放入大集合尾部
        while (p2 <= end) {
            tempArr[p++] = array[p2++];
        }
        // 大集合元素复制回原数组
        for (int i = 0; i < tempArr.length; i++) {
            array[i + start] = tempArr[i];
        }
    }

}
