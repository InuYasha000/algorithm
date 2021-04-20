package com.example.algorithm.sixhundred;

/**
 * @Auther: cheng
 * @Date: 2021/4/20 13:34
 * @Description:581. 最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subject581 {
    public int findUnsortedSubarray(int[] nums) {
        int start = 0;
        int end = -1;
        int max = nums[0];
        int min = nums[nums.length-1];
        for(int i=0;i<nums.length;i++){
            if(max>nums[i]){
                end = i;
            }else{
                max = nums[i];
            }
            if(min<nums[nums.length-1-i]){
                start = nums.length-1-i;
            }else{
                min = nums[nums.length-1-i];
            }
        }
        return end>start?end-start+1:0;
    }
}
