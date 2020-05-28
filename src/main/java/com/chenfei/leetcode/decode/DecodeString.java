package com.chenfei.leetcode.decode;

import java.util.Stack;

/**
 * 每日一练
 *      给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * @author chenfei
 * @since 2020/5/28
 */
public class DecodeString {

    static int i = 0;
    public static void main(String[] args) {
        String sourceStr = "100[leetcode]";
        System.out.println(decodeString(sourceStr));
    }

    private static String decodeString(String sourceStr) {
        Stack<String> stack = new Stack<String>();
        for ( i = 0;i < sourceStr.length(); i++) {
            String s = String.valueOf(sourceStr.charAt(i));
            if(isNumber(s)){
                stack.push(getNumber(sourceStr));
                continue;
            }
            if ("]".equals(s)) {
                convert(stack);
                continue;
            }
            stack.push(s);
        }
        return result(stack);
    }

    private static void convert(Stack<String> stack) {
        StringBuffer sb = new StringBuffer();
        boolean numFlag = false;
        while (true) {
            String s = stack.pop();
            if("[".equals(s)){
                numFlag = true;
                continue;
            }
            if (numFlag){
                for (int i = 0; i < Integer.parseInt(s); i++) {
                    stack.push(sb.toString());
                }
                break;
            }
            if (!"[".equals(s)) {
                sb.insert(0, s);
            }
        }
    }

    private static String result(Stack<String> stack){
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }

    private static String getNumber(String sourceStr){
        StringBuffer sb = new StringBuffer();
        while (isNumber(String.valueOf(sourceStr.charAt(i)))){
            sb.append(String.valueOf(sourceStr.charAt(i)));
            i++;
        }
        i--;
        return sb.toString();
    }

    private static boolean isNumber(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
