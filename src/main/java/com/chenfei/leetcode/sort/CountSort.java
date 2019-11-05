package com.chenfei.leetcode.sort;

import com.chenfei.leetcode.utils.JsonUtil;

/**
 * @author chenfei
 * @description 计数排序
 * 不是稳定排序,相同内容排序后不知道顺序
 * 改进版本是稳定排序
 * @since 2019/11/4
 */
public class CountSort {

    public static void main(String[] args) {
        countSort();
        // 优化版本,稳定排序
        countSortStable();
    }

    private static void countSort() {
        int[] oldArray = new int[]{4, 4, 6, 5, 3, 2, 8, 1, 7, 5, 6, 0, 10};
        System.out.println("原数组值:" + JsonUtil.toString(oldArray));
        int[] oldArrayMinMaxArray = getOldArrayMinMax(oldArray);
        System.out.println("原数组最小值最大值:" + JsonUtil.toString(oldArrayMinMaxArray));
        int[] countArray = getCountArray(oldArray, oldArrayMinMaxArray);
        System.out.println("统计数组值:" + JsonUtil.toString(countArray));
        int[] sortArray = getSortArray(countArray, oldArray.length, oldArrayMinMaxArray[0]);
        System.out.println("排序后数组值:" + JsonUtil.toString(sortArray));
    }

    private static void countSortStable() {
        int[] oldArray = new int[]{95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        System.out.println("原数组值:" + JsonUtil.toString(oldArray));
        int[] oldArrayMinMaxArray = getOldArrayMinMax(oldArray);
        System.out.println("原数组最小值最大值:" + JsonUtil.toString(oldArrayMinMaxArray));
        int[] countArray = getCountArray(oldArray, oldArrayMinMaxArray);
        System.out.println("统计数组值:" + JsonUtil.toString(countArray));
        convertCountArray(countArray);
        System.out.println("转换后统计数组值:" + JsonUtil.toString(countArray));
        int[] sortArray = getSortArrayStable(countArray, oldArray, oldArrayMinMaxArray[0]);
        System.out.println("稳定排序后数组值:" + JsonUtil.toString(sortArray));
    }


    /**
     * 根据原数组生成统计数组
     *
     * @param oldArray
     * @param oldArrayMinMaxArray
     * @return
     */
    private static int[] getCountArray(int[] oldArray, int[] oldArrayMinMaxArray) {
        int countArrayLength = oldArrayMinMaxArray[1] - oldArrayMinMaxArray[0] + 1;
        System.out.println("统计数组长度: " + countArrayLength);
        int[] countArray = new int[countArrayLength];
        for (int i = 0; i < oldArray.length; i++) {
            countArray[oldArray[i] - oldArrayMinMaxArray[0]]++;
        }
        return countArray;
    }

    /**
     * 根据统计数组,生成排序后数组
     *
     * @param countArray
     * @param sortLength
     * @param oldArrayMin
     * @return
     */
    private static int[] getSortArray(int[] countArray, int sortLength, int oldArrayMin) {
        int[] sortArray = new int[sortLength];
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j = countArray[i]; j > 0; j--) {
                sortArray[index++] = i + oldArrayMin;
            }
        }
        return sortArray;
    }

    /**
     * 统计原数组最小值最大值,用于计算统计数组大小
     *
     * @param oldArray
     * @return
     */
    private static int[] getOldArrayMinMax(int[] oldArray) {
        int[] minMaxArray = new int[2];
        int min = oldArray[0], max = oldArray[0];
        for (int i = 1; i < oldArray.length; i++) {
            if (min > oldArray[i]) {
                min = oldArray[i];
            }
            if (max < oldArray[i]) {
                max = oldArray[i];
            }
        }
        minMaxArray[0] = min;
        minMaxArray[1] = max;
        return minMaxArray;
    }

    //===============统计排序改进版,相同值按原顺序排序

    /**
     * 转换统计数组,使统计数组值等于原数组的最终排序位置
     *
     * @param countArray
     */
    private static void convertCountArray(int[] countArray) {
        int sum = 0;
        for (int i = 0; i < countArray.length; i++) {
            sum = countArray[i] + sum;
            countArray[i] = sum;
        }
    }

    /**
     * 根据转换后统计数组和原数组,得到排序后数组
     *
     * @param countArray
     * @param oldArray
     * @param oldArrayMin
     * @return
     */
    private static int[] getSortArrayStable(int[] countArray, int[] oldArray, int oldArrayMin) {
        int[] sortArray = new int[oldArray.length];
        for (int i = oldArray.length - 1; i >= 0; i--) {
            sortArray[countArray[oldArray[i] - oldArrayMin] - 1] = oldArray[i];
            countArray[oldArray[i] - oldArrayMin]--;
        }
        return sortArray;
    }
}
