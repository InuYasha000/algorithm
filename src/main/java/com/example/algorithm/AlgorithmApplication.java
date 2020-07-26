package com.example.algorithm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AlgorithmApplication {

    public static void main(String[] args) {
        getRow(3);
//        generate(5);
        SpringApplication.run(AlgorithmApplication.class, args);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(1);
        res.add(Arrays.asList(1));
//        res.add(list);
        for(int i=1;i<numRows;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=1;j<i;j++){
                temp.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }

    public static List<Integer> getRow(int rowIndex) {
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
