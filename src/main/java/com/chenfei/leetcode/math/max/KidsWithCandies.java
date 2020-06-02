package com.chenfei.leetcode.math.max;

import com.chenfei.leetcode.utils.JsonUtil;

/**
 * TODO
 *
 * @author chenfei
 * @since 2020/6/1
 */
public class KidsWithCandies {

    public static void main(String[] args) {
        int[] candies = new int[]{2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(JsonUtil.toString(kidsWithCandies(candies,extraCandies)));
    }

    private static boolean[] kidsWithCandies(int[] candies,int extraCandies){
        int max = 0;
        int[] tmp = new int[candies.length];
        boolean[] result = new boolean[candies.length];
        for(int i= 0;i<candies.length;i++){
            max = Math.max(max,candies[i]);
            tmp[i] = candies[i] + extraCandies;
        }
        for(int j= 0;j<tmp.length;j++){
            if(tmp[j] >= max){
                result[j] = true;
            }else{
                result[j] = false;
            }
        }
        return result;
    }
}
