package com.example.algorithm.twohundred;

/**
 * @Auther: cheng
 * @Date: 2020/8/8 18:31
 * @Description:多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 */
public class Subject169 {
    public static void main(String[] args) {
        majorityElement(new int[]{1,2,1,3,1,4,1,5,1,7,2,8});
    }
    // public int majorityElement(int[] nums) {
    //     if(nums==null){
    //         return 0;
    //     }
    //     Map<Integer,Integer> map = new HashMap<>();
    //     int max = Integer.MIN_VALUE;
    //     int res = nums[0];
    //     for(int i:nums){
    //         if(map.containsKey(i)){
    //             map.put(i,map.get(i)+1);
    //             if(max<map.get(i)){
    //                 res = i;
    //                 max = map.get(i);
    //             }
    //         }else{
    //             map.put(i,1);
    //         }
    //     }
    //     return res;
    // }
    //摩尔投票法
    public static int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for(int i:nums){
            if(count==0){
                count++;
                res = i;
            }else{
                if(res==i){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return res;
    }
}
