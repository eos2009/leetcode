package com.chenfei.leetcode.sort;

import com.chenfei.leetcode.utils.JsonUtil;

/**
 * @author chenfei
 * @description 基数排序：多用于字符串排序
 * @since 2019/11/5
 */
public class RadixSort {

    public static void main(String[] args) {
        String[] oldArray = {"qd", "abc", "qwe", "hhh", "a", "cws", "ope"};
        //1、求数组最长字符串
        int maxLength = getStrMaxLength(oldArray);
        //2、使用LSD从低位优先排序
        String[] sortArray = radixSort(oldArray,maxLength);
        System.out.println("基数排序后数组值:" + JsonUtil.toString(sortArray));
    }

    /**
     * 基数排序
     * @param oldArray
     * @param maxLength
     * @return
     */
    public static String[] radixSort(String[] oldArray, int maxLength) {
        String[] sortArray = null;
        for (int k = maxLength - 1; k >= 0; k--) {
            // 计数数组大小,使用ascii码范围作为数组长度
            int[] countArray = new int[128];
            for (int i = 0; i < oldArray.length; i++) {
                int index = getCharIndex(oldArray[i],k);
                countArray[index]++;
            }
            // 计数数组转换处理
            convertCountArray(countArray);
            // 倒序遍历原数组,计算出排序后数组
            sortArray = getSortArrayStable(countArray,oldArray,k);
            // 下一次排序基于本次排序结果
            oldArray = sortArray;
        }
        return sortArray;
    }

    /**
     * 获取原数组最长字符串长度
     * @param oldArray
     * @return
     */
    private static int getStrMaxLength(String[] oldArray) {
        int maxLength = 0;
        for (String str : oldArray) {
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }
        return maxLength;
    }

    /**
     * 获取字符串对应位ascii码值,长度不足为0
     * @param str
     * @param k
     * @return
     */
    private static int getCharIndex(String str, int k) {
        if (str.length() < k + 1) {
            return 0;
        }
        return str.charAt(k);
    }


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
     * @return
     */
    private static String[] getSortArrayStable(int[] countArray, String[] oldArray,int k) {
        String[] sortArray = new String[oldArray.length];
        for (int i = oldArray.length - 1; i >= 0; i--) {
            int index = getCharIndex(oldArray[i],k);
            int sortIndex = countArray[index] - 1;
            sortArray[sortIndex] = oldArray[i];
            countArray[index]--;
        }
        return sortArray;
    }
}
