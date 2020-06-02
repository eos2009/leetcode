package com.chenfei.leetcode.math.sum;

/**
 * TODO
 *
 * @author chenfei
 * @since 2020/6/2
 */
public class SumNums {

    public static void main(String[] args) {
        System.out.println(sumNums(9));
    }

    private static int sumNumsByRecursion(int n){
        if(n == 0){
            return 0;
        }
        return n+sumNumsByRecursion(n-1);
    }


    private static int sumNums(int n){
        boolean flag = n>0 && (n += sumNums(n-1)) >0;
        return n;
    }

}
