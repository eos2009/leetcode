package com.chenfei.leetcode;

import com.chenfei.leetcode.math.other.HuiWen;
import com.chenfei.leetcode.math.other.RomeNum;
import com.chenfei.leetcode.math.other.StrNum;
import com.chenfei.leetcode.math.reverse.ReverseInt;
import com.chenfei.leetcode.math.sum.TwoSum;
import com.chenfei.leetcode.utils.JsonUtil;

/**
 * @author chenfei
 * @description
 * @since 2019/7/19
 */
public class Test {

    public static void main(String[] args) {
        //twoSum();
        //reverse();
        //str2intArr();
        //isHuiWen();
        //romeToInt();

        int p = 0;
        int q = 0;
        System.out.println(p++);
        System.out.println(p);
        System.out.println(++q);
        System.out.println(q);
    }

    public static void twoSum(){
        int[] nums = new int[]{1,2,3,4,5,8,9,6,7};
        int target = 16;
        TwoSum twoSum = new TwoSum();
        try {
            long start = System.currentTimeMillis();
            int[] result = twoSum.twoSum(nums,target);
            System.out.println("用时:"+(System.currentTimeMillis()-start));
            System.out.println("符合的数据下标:"+JsonUtil.toString(result));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("沒有符合的数据");
        }
    }

    public static void reverse(){
        ReverseInt reverseInt = new ReverseInt();
        int source = Integer.MAX_VALUE;
        System.out.println("原数据:"+ source);
        System.out.println("目标数据:"+ reverseInt.reverse(source));
    }

    public static void str2intArr(){
        StrNum strNum = new StrNum();
        String str = "DDI";
        System.out.println("原字符串:"+ str);
        System.out.println("目标数组:"+ JsonUtil.toString(strNum.str2intArr(str)));
    }

    public static void isHuiWen(){
        HuiWen huiWen = new HuiWen();
        int n = 111121111;
        System.out.println("原值:"+ n);
        System.out.println("是否回文:"+ huiWen.isHuiWen(n));
    }

    public static void romeToInt(){
        RomeNum romeNum = new RomeNum();
        String rome = "IVIICDD";
        System.out.println("原值:"+ rome);
        System.out.println("是否回文:"+ romeNum.romeToInt(rome));
    }

}
