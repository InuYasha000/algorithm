package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2021/4/25 09:12
 * @Description:34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subject34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        //true代表搜左边
        res[0] = searchRangeHelper(nums,0,nums.length-1,target,true);
        res[1] = searchRangeHelper(nums,0,nums.length-1,target,false);
        return res;
    }
    public int searchRangeHelper(int[] nums,int left,int right,int target,boolean flag){
        int mid = 0;
        int res = -1;
        while(left<=right){
            mid = (left+right)/2;
            if(target<nums[mid]){
                right = mid-1;
            }else if(target>nums[mid]){
                left = mid+1;
            }else{
                res = mid;
                if(flag){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return res;
    }
}
