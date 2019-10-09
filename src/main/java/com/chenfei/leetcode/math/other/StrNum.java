//题目：
//给定只含 "I"（增大）或 "D"（减小）的字符串S，令N = S.length。
//
//        返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
//
//        如果 S[i] == "I"，那么 A[i] < A[i+1]
//        如果 S[i] == "D"，那么 A[i] > A[i+1]
//
//        示例 1：
//        输出："IDID"
//        输出：[0,4,1,3,2]
//
//        示例 2：
//        输出："III"
//        输出：[0,1,2,3]
//
//        示例 3：
//        输出："DDI"
//        输出：[3,2,0,1]
//
//        提示：
//        1 <= S.length <= 1000
//        S 只包含字符 "I" 或 "D"。

package com.chenfei.leetcode.math.other;

/**
 * @author chenfei
 * @description
 * @since 2019/7/19
 */
public class StrNum {

    private static final char D = 'D';
    private static final char I = 'I';

    public int[] str2intArr(String str){
        int length = str.length();
        int[] result = new int[length+1];
        int[] intArr = new int[length+1];
        for(int i = 0; i< intArr.length;i++){
            intArr[i] = i;
        }
        int dCnt = intArr.length - 1;
        int iCnt = 0;
        for(int i = 0; i< length;i++){
            if(D == str.charAt(i)){
                result[i] = intArr[dCnt];
                dCnt--;
            }
            if(I == str.charAt(i)){
                result[i] = intArr[iCnt];
                iCnt++;
            }
        }
        result[length] = intArr[iCnt];
        return result;
    }

}
