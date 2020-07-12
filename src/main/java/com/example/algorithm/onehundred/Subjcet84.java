package com.example.algorithm.onehundred;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description:柱状图中最大的矩形
 * @Date:2020/7/11
 * @Author: Cheng
 */
public class Subjcet84 {
    //最外面的for循环是O(n)，这个毋庸置疑，while循环了多少次才是复杂度的根本所在，while循环的次数就是stack.pop()的次数，stack的元素全部来源于stack.push()，
    // 也就是pop次数一定小于push次数，而stack.push次数是一个常数级别的次数(要注意这是常数级别，即使全部入栈，也就是次数为tmp.length，它还是常数级别，因为他的来源整个循环的和，而不是某一次都是这个次数)，
    // 所以复杂度是O(n)
    public int largestRectangleArea(int[] heights) {
        // 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        Deque<Integer> stack = new ArrayDeque<>();
        int resArea = 0;
        for(int i=0;i<tmp.length;i++){
            while(!stack.isEmpty()&&tmp[i]<tmp[stack.peek()]){
                int height = tmp[stack.pop()];
                resArea = Math.max(height*(i-stack.peek()-1),resArea);
            }
            stack.push(i);
        }
        return resArea;
    }
}
