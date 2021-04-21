package com.example.algorithm.twohundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: cheng
 * @Date: 2020/8/6 22:15
 * @Description:最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 */
public class Subject155 {
    class MinStack {
        int min;
        List<Integer> list;
        /** initialize your data structure here. */
        public MinStack() {
            min = Integer.MAX_VALUE;
            list = new ArrayList<>();
        }

        public void push(int x) {
            list.add(x);
            min = Math.min(min,x);
        }

        public void pop() {
            list.remove(list.size()-1);
            min = Integer.MAX_VALUE;
            for(int i:list){
                min = Math.min(min,i);
            }
        }

        public int top() {
            return list.get(list.size()-1);
        }

        public int getMin() {
            return min;
        }
    }



    class MinStack1{

        private Node head;
        /** initialize your data structure here. */
        public MinStack1() {
        }

        public void push(int val) {
            if(head == null){
                head = new Node(val, val);
            }else{
                head = new Node(val, Math.min(val,head.min), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }

        private class Node {
            private int val;
            private int min;
            private Node next;

            private Node(int val, int min) {
                this(val, min, null);
            }

            private Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
