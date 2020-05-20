package com.example.algorithm;

/**
 * @Auther: cheng
 * @Date: 2020/5/20 22:13
 * @Description:盛最多水的容器
 * 先看两边高度（0，length-1）
 * 哪个高度低表示应该移动谁（因为移动另外一个肯定水减少，因为短板在这，移动本身才有可能增大）
 * 如果相等，倘若中间没有高于两边的，表示此时就是最大，不管怎么移动都无所谓
 * 倘若中间有两根高的，此时有可能增大的可能在于两边的柱子最终全部移到高的两根（这句话好好理会，一定注意短板，一根柱子两边肯定有一根是短板，两根一样的表示一定要移动到中间）
 * 此时也无所谓移动，到了两根柱子中间此时就跟第一种情况一样了，
 * 综上，可以使用最直接的方式求解
 */
public class Subject11 {
    public int maxArea(int[] height) {
        int max = 0, l = 0, r = height.length - 1;
        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
