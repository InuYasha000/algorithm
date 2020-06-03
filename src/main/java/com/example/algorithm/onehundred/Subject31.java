package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/5/23 18:51
 * @Description:下一个排列
 */
public class Subject31 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 1};
        nextPermutation(nums);
//        System.out.println(nums);
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {//没有，倒序输出
            nums = reverse(nums, 0, nums.length - 1);
            return;
        }
        int j = i + 1;
        while (j <= nums.length - 1 && nums[j] > nums[i]) {//这里不能加等号，原因在于j-1会回到相等的位置，而不是大于的位置，比如[1,5,1]会到1而不是5.
            j++;
        }
        nums = swap(nums, i, j - 1);
        nums = reverse(nums, i + 1, nums.length - 1);
    }

    public static int[] reverse(int nums[], int start, int end) {
        while (start < end) {
            nums = swap(nums, start, end);
            start++;
            end--;
        }
        return nums;
    }

    public static int[] swap(int nums[], int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        return nums;
    }
}
