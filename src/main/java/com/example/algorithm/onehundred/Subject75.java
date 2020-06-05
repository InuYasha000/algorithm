package com.example.algorithm.onehundred;

import javax.crypto.spec.PSource;
import java.util.Arrays;

/**
 * @Description:颜色分类
 * @Date:2020/6/5
 * @Author: Cheng
 */
public class Subject75 {
    public static void main(String[] args) {
        int nums[] = new int[]{2,2,1};
        sortColors(nums);
        Arrays.stream(nums).forEach(x-> System.out.println(x));
    }
    public static void sortColors(int[] nums) {
        int index0=0,index2=nums.length-1;
        for(int i=0;i<=index2;i++){
            while(index0<=index2&&nums[index0]==0){
                index0++;
                i=index0;
            }
            while(index2>=index0&&nums[index2]==2){
                index2--;
            }
            if(index0>index2){
                break;
            }
            if(nums[i]==2&&i<index2){
                swap(nums,index2,i);
                index2--;
            }
            if(nums[i]==0&&i>index0){
                swap(nums,index0,i);
                index0++;
            }
        }
    }

    public static void swap(int nums[],int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void sortColors1(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (count0 > 0) {
                nums[i] = 0;
                count0--;
            } else if (count1 > 0) {
                nums[i] = 1;
                count1--;
            } else if (count2 > 0) {
                nums[i] = 2;
                count2--;
            }
        }
    }
}
