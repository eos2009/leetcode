package com.chenfei.leetcode.math.sum;

/**
 * TODO
 *
 * @author chenfei
 * @since 2020/6/3
 */
public class New21Game {

    public static void main(String[] args) {

    }

    private static double new21Game(int n, int k, int w) {
        if (k - 1 + w <= n) {
            return 1.0;
        }
        double[] dp = new double[k + w];
        for (int i = k; i <= n; i++) {
            dp[i] = 1.0;
        }
        double sumProb = n - k + 1;
        for (int i = k - 1; i >= 0; i--) {
            dp[i] = sumProb / w;
            sumProb = sumProb - dp[i + w] + dp[i];
        }

        return dp[0];
    }
}
