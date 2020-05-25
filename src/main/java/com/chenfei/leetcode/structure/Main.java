package com.chenfei.leetcode.structure;

/**
 * TODO
 *
 * @author chenfei
 * @since 2020/5/25
 */
public class Main {
    public static void main(String[] args) {
        LruCache lruCache = new LruCache(2);

        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        lruCache.put(3,3);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));


    }
}
