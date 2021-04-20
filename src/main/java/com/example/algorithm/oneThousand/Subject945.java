package com.example.algorithm.oneThousand;

import java.util.Arrays;

/**
 * @Auther: cheng
 * @Date: 2021/4/20 13:47
 * @Description:945. 使数组唯一的最小增量
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 *
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 示例 1:
 *
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 示例 2:
 *
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subject945 {
    public int minIncrementForUnique(int[] A) {
        if(A==null||A.length==0||A.length==1){
            return 0;
        }
        Arrays.sort(A);
        int max = A[0];
        int count = 0;
        for(int i=1;i<A.length;i++){
            if(A[i]<=max){
                //最起码要变成前数+1，这样递增步骤是最少的
                count+=max+1-A[i];
                max = max+1;
            }else{
                max = A[i];
            }
        }
        return count;
    }
}
