package com.chenfei.leetcode.math.other;

/**
 * @author chenfei
 * @description
 * @since 2019/7/22
 */
public class HuiWen {

    public boolean isHuiWen(int n){
        int oriNum = n;
        int mod = 10;
        if(n<0 || (n%mod == 0)){
            return false;
        }
        if(n == 0){
            return true;
        }
        int reverse = 0;
        while(n > 0){
           int di = n%mod;
           reverse = reverse * mod +di;
           n = n/mod;
        }
        if(oriNum == reverse){
            return true;
        }
        return false;
    }
}
