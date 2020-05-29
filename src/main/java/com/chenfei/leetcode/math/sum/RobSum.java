package com.chenfei.leetcode.math.sum;

/**
 * 每日一练
 *      打家劫舍
 *
 * @author chenfei
 * @since 2020/5/29
 */
public class RobSum {

    public static void main(String[] args) {
        int[] arr = new int[0];
        System.out.println(rob(arr));
    }

    private static int rob(int[] arr){
        return getMax(arr,arr.length-1);
    }

    private static int getMax(int[] arr){
        if(arr == null || arr.length <= 0){
            return 0;
        }
        int length = arr.length;
        if(length==1){
            return arr[0];
        }
        int first = arr[0];
        int second = Math.max(arr[0],arr[1]);
        for(int i =2;i< length;i++){
            int tmp = second;
            second = Math.max(second,first+arr[i]);
            first = tmp;
        }
        return second;
    }
}
