package com.example.algorithm.twohundred;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Auther: cheng
 * @Date: 2020/8/4 21:07
 * @Description:LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *  
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *  
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 )缓存容量;
 *      cache.put(1,1);
 *      cache.put(2,2);
 *      cache.get(1);       // 返回  1
 *      cache.put(3,3);    // 该操作会使得关键字 2 作废
 *      cache.get(2);       // 返回 -1 (未找到)
 *      cache.put(4,4);    // 该操作会使得关键字 1 作废
 *      cache.get(1);       // 返回 -1 (未找到)
 *      cache.get(3);       // 返回  3
 *      cache.get(4);       // 返回  4
 */
public class Subject146 {
    class LRUCache{
        Queue<Integer> queue ;
        Map<Integer,Integer> indexMap ;
        int size;
        public LRUCache(int capacity) {
            queue = new LinkedList<>();
            indexMap = new HashMap<>();
            this.size = capacity;
        }

        public int get(int key) {
            if(indexMap.containsKey(key)){
                queue.remove(key);
                queue.add(key);
                return indexMap.get(key);
            }else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(indexMap.containsKey(key)){
                queue.remove(key);
            }else{
                size=(size<0?size:size-1);
            }
            indexMap.put(key,value);
            queue.add(key);
            if(size<0){
                indexMap.remove(queue.poll());
                size++;
            }
        }
    }
    class LRUCache2 {
        Map<Integer,LinkedNode> map;
        int capacity;
        LinkedNode head;
        LinkedNode tail;
        class LinkedNode{
            LinkedNode pre;
            LinkedNode next;
            int key;
            int value;
            public LinkedNode(int key,int value){
                this.key = key;
                this.value = value;
            }
            public LinkedNode(){}
        }
        public LRUCache2(int capacity) {
            this.map = new HashMap<>();
            this.capacity = capacity;
            head = new LinkedNode();
            tail = new LinkedNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                LinkedNode node = map.get(key);
                remove(node);
                addToHead(node);
                return node.value;
            }else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                LinkedNode node = map.get(key);
                remove(node);
                node.value = value;
                addToHead(node);
            }else{
                LinkedNode node = new LinkedNode(key,value);
                addToHead(node);
                map.put(key,node);
                this.capacity--;
            }
            if(this.capacity<0){
                LinkedNode node2 = tail.pre;
                map.remove(node2.key);
                remove(node2);
                this.capacity++;
            }
        }
        public void addToHead(LinkedNode node){
            node.next = head.next;
            head.next.pre = node;
            node.pre = head;
            head.next = node;
        }
        public void remove(LinkedNode node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }
}
