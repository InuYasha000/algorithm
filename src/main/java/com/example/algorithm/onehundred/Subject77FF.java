package com.example.algorithm.onehundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: cheng
 * @Date: 2020/6/6 12:06
 * @Description:组合
 */
public class Subject77FF {
    public static void main(String[] args) {
        combine(10,3);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        getAns(1,n, k, new ArrayList<Integer>(), ans);
        return ans;
    }

    public static void getAns(int start, int n, int k, ArrayList<Integer> temp, List<List<Integer>> ans) {
        if(temp.size() == k){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = start; i <= n - (k -temp.size()) + 1; i++) {
            temp.add(i);
            getAns(i+1, n, k, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

}
