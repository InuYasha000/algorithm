package com.example.algorithm.threehundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: cheng
 * @Date: 2020/9/5 18:36
 * @Description:课程表 II
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 *
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 说明:
 *
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 *
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 *
  */
public class Subject210 {
    /**
     * 当某个节点的入度为 0，表示没有节点指向它，即该课程不需要先修其他课程，那么我们就可以从 该课程 出发
     *
     *         然后我们将入度为 0 的节点存储进队列中，将它和它所能到达的节点 next 的通路断开，即 next 的入度 -1，
     *         当减为 0 的时候，表示入度为 0，那么添加进队列中
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] points = new int[numCourses];
        //存储某个节点能够到达的其他节点集合,节点值可以直接作为下标
        List<Integer>[] lists = new ArrayList[numCourses];
        for(int []temp:prerequisites){
            // [3, 5] 表示学习 3 之前需要先学习 5 那么对于 3 来说， 5 指向 3，即 3 的入度 + 1 而 5 能到达的节点集合需要增加 3 这个节点
            points[temp[0]]++;
            if(lists[temp[1]]==null){
                lists[temp[1]] = new ArrayList<>();
            }
            lists[temp[1]].add(temp[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        //找到入度为 0 的节点
        for(int i=0;i<points.length;i++){
            if(points[i]==0){
                queue.add(i);
            }
        }
        //记录遍历的课程顺序
        int res[] = new int[numCourses];
        int index = 0;
        //首先我们应该明确这么一点，在队列中的元素都是 0 入度的课程，即没有需要前修的课程就可以直接学习
        // 那么我们遍历到该课程，假设学习完，那么它指向的课程入度都需要 -1，当它指向的某个课程入度为 0 的时候，同时也需要将该课程添加到队列中
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                int i = queue.poll();
                res[index++] = i;
                List<Integer> temp = lists[i];
                if(temp==null){
                    continue;
                }
                for(int in:temp){
                    points[in]--;
                    if(points[in]==0){
                        queue.add(in);
                    }
                }
            }
        }
        //idx == numCourses 意味着全部课程都访问过了，即最终都能够满足 0 入度的条件，即全部能够学习完成
        return index==numCourses?res:new int[0];
    }
}
