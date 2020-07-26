package com.example.algorithm.twohundred;

/**
 * @Auther: cheng
 * @Date: 2020/7/25 18:45
 * @Description:买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 */
public class Subject121 {
    public int maxProfit(int[] prices) {
        int buyIndex = 0,sellIndex = 0,maxProfit = 0;
        for(;sellIndex<prices.length;sellIndex++){
            if(prices[buyIndex]>prices[sellIndex]){
                buyIndex = sellIndex;
            }else{
                maxProfit = Math.max(maxProfit,prices[sellIndex]-prices[buyIndex]);
            }
        }
        return maxProfit;
    }

    //这个方法就是寻找最大子数列-Kadane算法
    //先将数组转换成后数-前数，再相加就代表两个数之间最大差值
    public int maxProfit1(int[] prices) {
        int maxProfit= 0,dp = 0,subValue = 0;//这里dp为0表示一旦没有符合的情况，就表示最大利润为0
        for(int i=0;i<prices.length;i++){//这里从1开始，表示第一天啥也没有，啥也不干
            subValue = prices[i]-prices[i-1];
            dp = Math.max(subValue,subValue+dp);
            maxProfit = Math.max(maxProfit,dp);
        }
        return maxProfit;
    }
}
