package com.example.algorithm.onehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:缺失的第一个正数
 * @Date:2020/6/1
 * @Author: Cheng
 */
public class Subject56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int i = 0;
        int len = intervals.length;
        while (i < len) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < len - 1 && right >= intervals[i + 1][0]) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            list.add(new int[]{left, right});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}
