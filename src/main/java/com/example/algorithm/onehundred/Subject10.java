package com.example.algorithm.onehundred;

/**
 * @Auther: cheng
 * @Date: 2021/4/28 08:07
 * @Description:10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *  
 * 示例 1：
 *
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 *
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4：
 *
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5：
 *
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subject10 {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()){
            return s.isEmpty();
        }
        // else if(s.isEmpty()){
        //     return p.isEmpty();
        // }
        //这里不能按照else if逻辑和下面走的原因是aa和a*这种类型，需要aa变成""继续和a*比较才有结果
        // boolean firstMatch = s.charAt(0)==p.charAt(0)||p.charAt(0)=='.';
        boolean firstMatch = (!s.isEmpty())&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');
        if(p.length()>1&&p.charAt(1)=='*'){
            return isMatch(s,p.substring(2))||(firstMatch&&isMatch(s.substring(1),p));
        }else{
            return firstMatch&&isMatch(s.substring(1),p.substring(1));
        }
    }
}
