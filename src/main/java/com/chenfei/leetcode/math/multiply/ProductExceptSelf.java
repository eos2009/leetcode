package com.chenfei.leetcode.math.multiply;

/**
 * TODO
 *
 * @author chenfei
 * @since 2020/6/4
 */
public class ProductExceptSelf {

    public static void main(String[] args) {

    }

    private static int[] productExceptSelf(int[] sourceArr){
        int[] targetArr = new int[sourceArr.length];
        int multiplySum = 1;
        int zeroIndex = 0;
        boolean zeroFlag = false;
        for(int i=0;i<sourceArr.length;i++){
            if(!zeroFlag && sourceArr[i] == 0){
                zeroIndex = i;
                zeroFlag = true;
               continue;
            }
            multiplySum = multiplySum * sourceArr[i];
        }
        if(zeroFlag){
            targetArr[zeroIndex] = multiplySum;
        }else{
            for(int i=0;i<sourceArr.length;i++){
                targetArr[i] = multiplySum / sourceArr[i];
            }
        }
        return targetArr;
    }



    private static int[] productExceptSelf1(int[] sourceArr){
        int[] targetArr = new int[sourceArr.length];
        int[] leftArr = new int[sourceArr.length];
        int[] rightArr = new int[sourceArr.length];
        leftArr[0] = 1;
        for(int i=1;i<sourceArr.length;i++){
            leftArr[i] = sourceArr[i-1] * leftArr[i-1];
        }
        rightArr[sourceArr.length-1] = 1;
        for(int i=sourceArr.length-2;i>=0;i--){
            rightArr[i] = sourceArr[i+1] * rightArr[i+1];
        }
        for(int i=0;i<sourceArr.length;i++){
            targetArr[i] = leftArr[i] * rightArr[i];
        }
        return targetArr;
    }

    private static int[] productExceptSelf2(int[] sourceArr){
        int[] targetArr = new int[sourceArr.length];
        targetArr[0] = 1;
        for(int i=1;i<sourceArr.length;i++){
            targetArr[i] = sourceArr[i-1] * targetArr[i-1];
        }
        int R = 1;
        for(int i=sourceArr.length-1;i>=0;i--){
            targetArr[i] = R * targetArr[i];
            R *= sourceArr[i];
        }
        return targetArr;
    }
}
