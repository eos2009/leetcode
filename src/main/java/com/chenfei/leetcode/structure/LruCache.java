package com.chenfei.leetcode.structure;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计LRU缓存机制
 *
 * @author chenfei
 * @since 2020/5/25
 */
public class LruCache {

    private ListNode head;
    private ListNode tail;

    private Map<Integer,ListNode> map;
    private int capacity;

    public LruCache(int capacity){
        this.map = new HashMap<Integer, ListNode>(capacity);
        this.capacity = capacity;
        this.head = new ListNode(-1,-1);
        this.tail = new ListNode(-1,-1);
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public ListNode put(Integer key,Integer value){
        ListNode node;
        if(map.containsKey(key)){
            node = this.map.get(key);
            node.setValue(value);
            moveNode2Head(node);
            return node;
        }
        if(this.map.size() == this.capacity){
            ListNode tailNode = removeNodeForTail();
            this.map.remove(tailNode.getKey());
        }
        node = new ListNode(key,value);
        addNode(node);
        this.map.put(key,node);
        return node;
    }

    public Integer get(Integer key){
        if(!this.map.containsKey(key)){
            return -1;
        }
        ListNode node = this.map.get(key);
        moveNode2Head(node);
        return node.getValue();
    }

    /**
     * 新增新节点
     * @param node
     */
    private void addNode(ListNode node){
        node.next = this.head.next;
        this.head.next.pre = node;

        this.head.next = node;
        node.pre = this.head;

    }

    /**
     * 移动节点到表头
     * @param node
     */
    private void moveNode2Head(ListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;

        node.next = this.head.next;
        this.head.next.pre = node;

        this.head.next = node;
        node.pre = this.head;
    }

    /**
     * 删除表尾节点
     * @return
     */
    private ListNode removeNodeForTail(){
        ListNode node = this.tail.pre;

        this.tail.pre = node.pre;
        node.pre.next = this.tail;
        return node;
    }


    class ListNode{
        private int key;
        private int value;
        private ListNode pre;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int key,int value){
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public ListNode getPre() {
            return pre;
        }

        public void setPre(ListNode pre) {
            this.pre = pre;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
