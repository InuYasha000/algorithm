package com.example.algorithm.common;

/**
 * @Auther: cheng
 * @Date: 2020/7/22 22:57
 * @Description:
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node(int val){
        this.val = val;
    }
    public Node(Node left,Node right,Node next,Node val){
        val = val;
        left = left;
        right = right;
        next = next;
    }
}
