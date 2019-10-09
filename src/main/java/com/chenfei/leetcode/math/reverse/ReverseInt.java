// 题目：
//  给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//  示例1:
//      输入: 123
//      输出: 321
//  示例 2:
//      输入: -123
//      输出: -321
//  示例 3:
//      输入: 120
//      输出: 21
// 注意:
//  假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
//  请根据这个假设，如果反转后整数溢出那么就返回 0



package com.chenfei.leetcode.math.reverse;

/**
 * @author chenfei
 * @description
 * @since 2019/7/19
 */
public class ReverseInt {

    public int reverse(int x) {
        int target = 0;
        while (x != 0) {
            int pop = x % 10;
            target = target * 10 ;
            // 大于MAX_VALUE
            if (target > Integer.MAX_VALUE/10) {
                return 0;
            }
            if (target == Integer.MAX_VALUE/10 && pop > 7) {
                return 0;
            }
            // 小于MIN_VALUE
            if (target < Integer.MIN_VALUE/10) {
                return 0;
            }
            if (target == Integer.MIN_VALUE/10 && pop < -8) {
                return 0;
            }
            target = target + pop;
            x = x / 10;
        }
        return target;
    }
}
