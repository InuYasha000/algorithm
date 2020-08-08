package com.example.algorithm.twohundred;

import com.example.algorithm.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: cheng
 * @Date: 2020/8/8 21:37
 * @Description:二叉搜索树迭代器
 * 图见 https://leetcode-cn.com/problems/binary-search-tree-iterator/
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *  
 *
 * 提示：
 *
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 *
 */
public class Subject173 {

    class BSTIterator {
        Queue<Integer> queue = new LinkedList<>();
        public BSTIterator(TreeNode root) {
            if(root==null){
                return;
            }
            BSTIteratorHandler(root,queue);
        }

        /** @return the next smallest number */
        public int next() {
            return queue.poll();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !queue.isEmpty();
        }
        public void BSTIteratorHandler(TreeNode node,Queue<Integer> queue){
            if(node.left==null&&node.right==null){
                queue.offer(node.val);
                return ;
            }
            if(node.left!=null){
                BSTIteratorHandler(node.left,queue);
            }
            queue.add(node.val);
            if(node.right!=null){
                BSTIteratorHandler(node.right,queue);
            }
        }
    }
}
