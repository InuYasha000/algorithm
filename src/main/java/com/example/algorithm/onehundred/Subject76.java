package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2020/6/6 11:11
 * @Description:
 */
public class Subject76 {
    public static void main(String[] args) {
        minWindow("abc", "cba");
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        boolean has_res = false;
        int left = 0, right = 0;//左右指针
        int res_left = 0, res_right = 0;//窗口指针
        int count = t.length();//t字符创长度,用于判断是否全部字符串已经有了
        int res_length = Integer.MAX_VALUE;//窗口长度+1,表示出现结果会立马替换
        int arr[] = new int[128];//ASCII下标数组，刚好能分标出大小写
        for (int i = 0; i < t.length(); i++) {//这里取t的ascii
            arr[t.charAt(i)]++;
        }
        while (right <= s.length() - 1) {
            char c = s.charAt(right);
            arr[c]--;//这里对应下方++,必须同时对应
            if (arr[c] >= 0) {//上方--后还能大于0，表示是t中字符串
                count--;
            }
            while (count == 0) {//窗口左指针移动
                has_res = true;
                int temp_length = right - left + 1;
                if (temp_length < res_length) {//找到了更小的窗口
                    res_left = left;
                    res_right = right;
                    res_length = temp_length;
                }
                char tempc = s.charAt(left);
                arr[tempc]++;
                if (arr[tempc] > 0) {//注意这里大于0，没有等于，去除不是子字符串内容，和上面--对应
                    count++;
                }
                left++;
            }
            right++;
        }

        return has_res ? s.substring(res_left, res_right + 1) : "";
    }
}
