package com.example.algorithm.onehundred;

/**
 * @Description:接雨水
 * @Date:2020/7/11
 * @Author: Cheng
 */
public class Subject42 {
    //最边上是不会有水的
    public int trap(int[] height) {
        int resSum = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i > 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int temp = Math.min(maxLeft[i], maxRight[i]);
            if (temp > height[i]) {
                resSum += temp - height[i];
            }
        }
        return resSum;
    }

    public int trap1(int[] height) {
        int resSum = 0;
        int left = 1,right = height.length-2,leftMax = 0,rightMax = 0;
        for(int i=1;i<height.length-1;i++){
            //leftmax<rightmax，其实这一步我觉得有点问题
            if(height[left-1]<height[right+1]){
                leftMax = Math.max(leftMax,height[left-1]);
                if(leftMax>height[left]){
                    resSum+=leftMax-height[left];
                }
                left++;
            }else{
                rightMax = Math.max(rightMax,height[right+1]);
                if(rightMax>height[right]){
                    resSum+=rightMax-height[right];
                }
                right--;
            }
        }
        return resSum;
    }
}
