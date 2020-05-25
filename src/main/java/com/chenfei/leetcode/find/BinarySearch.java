package com.chenfei.leetcode.find;

/**
 *
 *
 * @author chenfei
 * @since 2020/5/22
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,9};
        System.out.println(binarySearch(arr,10));
        System.out.println(binarySearch(arr,7));
    }

    private static int binarySearch(int[] arr,int t){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int low = 0;
        int high = arr.length -1;
        int middle;
        while(low <= high){
            middle = (low + high) / 2;
            if(arr[middle] == t){
                return middle;
            }
            if(arr[middle] > t){
                high = middle -1;
                continue;
            }
            low = middle+1;
        }
        return -1;
    }



}
