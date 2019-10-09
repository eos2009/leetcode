//编写一个函数来查找字符串数组中的最长公共前缀。
//
//        如果不存在公共前缀，返回空字符串 ""。
//
//        示例 1:
//
//        输入: ["flower","flow","flight"]
//        输出: "fl"
//        示例 2:
//
//        输入: ["dog","racecar","car"]
//        输出: ""
//        解释: 输入不存在公共前缀。
//        说明:
//
//        所有输入只包含小写字母 a-z 。

package com.chenfei.leetcode.math.other;

/**
 * @author chenfei
 * @description
 * @since 2019/7/22
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String result = "";
        for (int i = 0; i < strs.length; i++) {
            result = strs[i].substring(0, i + 1);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() >= result.length() || strs[j].substring(0, i + 1).equals(result)) {

                }
            }
        }
        return result;
    }
}