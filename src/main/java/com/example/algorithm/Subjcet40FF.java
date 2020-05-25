package com.example.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: cheng
 * @Date: 2020/5/24 21:06
 * @Description:组合总和 II
 */
public class Subjcet40FF {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(candidates, result, new ArrayList<Integer>(), target, 0);
        return result;
    }

    public void backtrace(int[] candidates, List<List<Integer>> result, List<Integer> tempList, int target, int start) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                //跳过重复的数字
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                tempList.add(candidates[i]);
                //i -> i + 1 ，因为每个数字只能用一次，所以下次遍历的时候不从自己开始
                backtrace(candidates, result, tempList, target - candidates[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
