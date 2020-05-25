package com.chenfei.leetcode.sort;

import com.chenfei.leetcode.utils.JsonUtil;

/**
 * 选择排序
 *      时间复杂度O(n*n)
 * @author chenfei
 * @since 2020/5/25
 */
public class CheckSort {

    public static void main(String[] args) {
        int[] sourceArr = new int[]{2,4,3,1,7,5,8};
        System.out.println("原数组:"+JsonUtil.toString(sourceArr));
        long start = System.currentTimeMillis();
        System.out.println("排序后数组:"+JsonUtil.toString(sort(sourceArr))+" 用时:"+(System.currentTimeMillis()-start));
    }

    private static int[] sort(int[] sourceArr){
        for(int i=0;i<sourceArr.length -1;i++){
            int tmp = sourceArr[i];
            for(int j=i+1;j<sourceArr.length;j++){
                if(sourceArr[i] > sourceArr[j]){
                    sourceArr[i] = sourceArr[j];
                    sourceArr[j] = tmp;
                    tmp = sourceArr[i];
                }
            }
        }
        return sourceArr;
    }
}
