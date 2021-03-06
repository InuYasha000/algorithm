package com.example.algorithm.twohundred;

/**
 * @Auther: cheng
 * @Date: 2020/7/25 19:30
 * @Description:买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 提示：
 *
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 *
 */
public class Subject122 {
    public static void main(String[] args) {
        maxProfit(new int[]{6,1,3,2,4,7});
    }
    //其实就是求整个数组的增区间
    public static int maxProfit(int[] prices) {
        int maxProfitSum = 0;
        int buyIndex = 0,sellIndex = 1;
        for(;sellIndex<prices.length;sellIndex++){
            //这两个if不能颠倒，因为当出现下落趋势时，应该先加上之前上升区间的值，然后再去更新下一个买入的节点
            if(prices[sellIndex]<prices[sellIndex-1]){
                maxProfitSum += prices[sellIndex-1]-prices[buyIndex];
                buyIndex = sellIndex;
            }
            if(prices[sellIndex]<prices[buyIndex]){
                buyIndex = sellIndex;
            }
        }
        //防止一直是增区间
        if(prices[sellIndex-1]>prices[buyIndex]){
            maxProfitSum += prices[sellIndex-1]-prices[buyIndex];
        }
        return maxProfitSum;
    }
}
