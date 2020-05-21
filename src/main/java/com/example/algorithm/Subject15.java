package com.example.algorithm;

import java.util.*;

/**
 * @Description:三数和，
 * 1：三数和转化为2数
 * 2：求2数的时候可以map，也可以前后index向中间合并，但是后面方法好，因为后面方法能在数组重复值时使用，时间复杂度更低
 * @Date:2020/5/21
 * @Author: Cheng
 */
public class Subject15 {
    public static void main(String[] args) {
//        int nums[] = new int[]{-1,-1,0,1,2};
        int nums[] = new int[]{0, 0, 0, 2, 2};
//        int nums[] = new int[]{0,0,0,0};
        result = threeSum2(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> threeSum2(int[] num) {
        Arrays.sort(num); //排序
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            //为了保证不加入重复的 list,因为是有序的，所以如果和前一个元素相同，只需要继续后移就可以
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                //两个指针,并且头指针从i + 1开始，防止加入重复的元素
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        //元素相同要后移，防止加入重复的 list
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    static List<List<Integer>> result = new ArrayList<>();


    public static List<List<Integer>> threeSum(int[] nums) {
        if (null == nums || nums.length <= 2) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            twoSum(i, 0 - nums[i], nums);
        }
        return result;
    }

    public static void twoSum(int index, int sum, int nums[]) {
        Map<Integer, Integer> map = new HashMap<>();
        int temp = index - 1;
        if (temp >= 0 && nums[temp] == nums[index]) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
//            if () {
//
//            }
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            if (map.containsValue(sum - nums[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[index]);
                list.add(sum - nums[i]);
                list.add(nums[i]);
                result.add(list);
            }
            map.put(i, nums[i]);
        }
    }
}
