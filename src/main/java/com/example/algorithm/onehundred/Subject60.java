package com.example.algorithm.onehundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: cheng
 * @Date: 2020/6/1 23:30
 * @Description:第k个排列
 */
public class Subject60 {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> candidates = new ArrayList<>();
        int factorials[] = new int[n + 1];
        factorials[0] = 1;
        int fact = 1;
        for (int i = 1; i < n + 1; i++) {
            candidates.add(i);
            fact *= i;
            factorials[i] = fact;
        }
        k = k - 1;
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            index = k / factorials[i];
            sb.append(candidates.remove(index));
            k = k - index * factorials[i];
        }
        return sb.toString();
    }
}
