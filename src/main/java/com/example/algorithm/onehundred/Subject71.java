package com.example.algorithm.onehundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: cheng
 * @Date: 2020/6/3 22:30
 * @Description:简化路径
 */
public class Subject71 {
        public String simplifyPath(String path) {
            String [] strs = path.split("/");
            List<String> list = new ArrayList<>();
            for(String s:strs){
                if(s.isEmpty()||s.equals(".")){
                    continue;
                }
                list.add(s);
            }
            List<String> resList = new ArrayList<>();
            for(String s:list){
                if(s.equals("..")){
                    if(resList.size()>0){
                        resList.remove(resList.size()-1);
                    }
                }else{
                    resList.add(s);
                }
            }
            String s = "/" + String.join("/",resList);
            return s;
        }
}
