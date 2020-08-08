package com.example.algorithm.twohundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: cheng
 * @Date: 2020/7/23 22:43
 * @Description:杨辉三角II
 */
public class Subject119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i=1;i<=rowIndex;i++){
            for(int j=1;j<i;j++){
                list.set(j,list.get(j-1)+list.get(j));
            }
            list.add(1);
        }
        return list;
    }
}
