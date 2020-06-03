package com.example.algorithm.onehundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: cheng
 * @Date: 2020/5/24 20:54
 * @Description:组合总和
 */
public class Subject39FF {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        backtrace(result, new ArrayList<>(), target, candidates, 0);
        return result;
    }

    public void backtrace(List<List<Integer>> list, List<Integer> tempList, int target, int[] candidates, int start) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backtrace(list, tempList, target - candidates[i], candidates, i);
                //找到了一个解或者 remain < 0 了，将当前数字移除，然后继续尝试
                tempList.remove(tempList.size() - 1);
            }
        }

    }
}
