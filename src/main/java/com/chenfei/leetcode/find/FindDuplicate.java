package com.chenfei.leetcode.find;

/**
 * 每日一练--查找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次
 *
 * @author chenfei
 * @since 2020/5/26
 */
public class FindDuplicate {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 5, 2, 6, 7, 3};
        System.out.println(findDuplicate1(arr));
        System.out.println(findDuplicate2(arr));
        System.out.println(findDuplicate3(arr));
    }

    /**
     * 暴力算法O(n*n)
     *
     * @param arr
     * @return
     */
    private static int findDuplicate1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    /**
     * Floyd算法时间复杂度O(n)
     *
     * @param arr
     * @return
     */
    private static int findDuplicate2(int[] arr) {
        int slow = 0;
        int fast = 0;
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }

    /**
     * 二分查找时间复杂度O(n*logn)
     * @param arr
     * @return
     */
    private static int findDuplicate3(int[] arr) {
        int left = 1;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
