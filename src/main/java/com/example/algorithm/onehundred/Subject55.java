package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/5/28 01:17
 * @Description:跳跃游戏
 */
public class Subject55 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < i) {//能否跳到第i步。（不能只看能否跳到最后一步，因为有可能中间都跳不到。）
                return false;
            }
            max = Math.max(max, nums[i] + i);//（num[i]上面的数字是跳到下一步的，所以max是在后面加）
        }
        return true;
    }
}
