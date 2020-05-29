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
            char c = sourceStr.charAt(i);
            if(Character.isDigit(c)){
                stack.push(getNumber(sourceStr));
                continue;
            }
            if(Character.isLetter(c) || c == '['){
                stack.push(String.valueOf(c));
                continue;
            }
            convert(stack);
        }
        return result(stack);
    }

    private static void convert(Stack<String> stack) {
        StringBuffer sb = new StringBuffer();
        while (true) {
            String s = stack.pop();
            if("[".equals(s)){
                break;
            }
            sb.insert(0, s);
        }
        String num = stack.pop();
        for (int i = 0; i < Integer.parseInt(num); i++) {
            stack.push(sb.toString());
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
        while (Character.isDigit(sourceStr.charAt(i))){
            sb.append(String.valueOf(sourceStr.charAt(i)));
            i++;
        }
        i--;
        return sb.toString();
    }
}
