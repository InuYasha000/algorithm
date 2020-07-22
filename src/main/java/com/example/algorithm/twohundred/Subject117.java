package com.example.algorithm.twohundred;

import com.example.algorithm.common.Node;

/**
 * @Auther: cheng
 * @Date: 2020/7/22 23:11
 * @Description:填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *  
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *  
 *
 * 示例：
 *
 * 图见https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *  
 *
 * 提示：
 *
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 *
 */
public class Subject117 {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        if(root.left!=null){
            if(root.right!=null){
                root.left.next = root.right;
            }else{
                root.left.next = nextNode(root.next);
            }
        }
        if(root.right!=null){
            root.right.next = nextNode(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }
    public Node nextNode(Node node){
        while(node!=null){
            if(node.left!=null){
                return node.left;
            }
            if(node.right!=null){
                return node.right;
            }
            node = node.next;
        }
        return null;
    }
}
