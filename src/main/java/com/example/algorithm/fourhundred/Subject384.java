package com.example.algorithm.fourhundred;

import java.util.Arrays;
import java.util.Random;

/**
 * @Auther: cheng
 * @Date: 2021/4/20 12:28
 * @Description:384. 打乱数组
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *  
 *
 * 示例：
 *
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subject384 {
    class Solution {
        private int source[] ;
        private int nums[] ;
        public Solution(int[] nums) {
            source = Arrays.copyOf(nums,nums.length);
            this.nums = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return source;
        }

        //就是打乱顺序，打乱顺序保证随机本质就是先循环，然后随机找数字跟他换位置
        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            Random random = new Random();
            for(int i=0;i<nums.length;i++){
                int randomIndex = random.nextInt(nums.length-i)+i;
//                int randomIndex = random.nextInt(nums.length);
                if(randomIndex!=i){
                    swap(nums,i,randomIndex);
                }
            }
            return nums;
        }
        public void swap(int[] nums,int left,int right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
}
