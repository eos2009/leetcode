package com.chenfei.leetcode.math.div;

import java.util.HashMap;
import java.util.Map;

/**
 * 每日一练
 *      和可被 K 整除的子数组
 *
 * @author chenfei
 * @since 2020/5/27
 */
public class SubArraysDivByK {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subArraysDivByK(arr, k));
    }

    private static int subArraysDivByK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int sum = 0;
        int result = 0;
        int mod,cnt;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            mod = (sum % k + k) % k;
            if (map.get(mod) == null) {
                cnt = 0;
            } else {
                cnt = map.get(mod);
            }
            result = result + cnt;
            map.put(mod, cnt + 1);
        }
        return result;
    }
}
