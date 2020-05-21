package com.chenfei.leetcode.distance;

/**
 * 最短编辑距离
 *
 * @author chenfei
 * @since 2020/5/21
 */
public class MinDistance {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(distance("Donald Trump","Trump Donald"));
        System.out.println(System.currentTimeMillis()-startTime);
    }

    /**
     * 最小距离
     * @param str1
     * @param str2
     * @return
     */
    private static int distance(String str1,String str2){
        //校验合法性
        if(str1 == null || str2 == null || "".equals(str1) || "".equals(str2)){
            return -1;
        }
        if(str1.equals(str2)){
            return 0;
        }
        // 初始化
        int lengthStr1 = str1.length();
        int lengthStr2 = str2.length();
        int[][] d = new int[lengthStr1+1][lengthStr2+1];
        for(int i= 0;i<=lengthStr1;i++){
            d[i][0] = i;
        }
        for(int j= 0;j<=lengthStr2;j++){
            d[0][j] = j;
        }
        // 计算
        for(int i=1;i<=lengthStr1;i++){
            for(int j=1;j<=lengthStr2;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    d[i][j] = d[i-1][j-1];
                }else{
                    d[i][j] = Math.min(Math.min(d[i][j-1], d[i-1][j]),d[i-1][j-1])+1;
                }
            }
        }
        return d[lengthStr1][lengthStr2];
    }

}
