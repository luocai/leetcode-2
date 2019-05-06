package code;
/*
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * 题意：最佳时间买卖股票，有冷却期，如果前一天卖了，下一天就不能买
 * 难度：Medium
 * 分类：Dynamic Programming
 * 思路：状态DP，自己不会写。要分两种状态，手中有股票时最大收益，手中没股票时最大收益(包括冷冻期)。
 *      buy[i] = max( buy[i-1], sell[i-2]-price[i] )
 *      sell[i] = max( sell[i-1], buy[i-1]+price[i] )
 *      空间压缩以后时间是O(n)，空间是O(1)
 * Tips：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75931/Easiest-JAVA-solution-with-explanations
 *      lc121, lc309, lc188, lc123, lc714
 */
public class lc309 {
    
    // 状态dp
    // 状态变化如下
    //dp1 | dp3 -> dp1
    //dp2 -> dp2
    //dp2 | dp3 -> dp3
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        //dp1[i]表示第i天手上有股票的最大收益（前i天的最后一个状态是买入）
        int[] dp1 = new int[prices.length];
        //dp2[i]表示第i天卖出股票的最大收益
        int[] dp2 = new int[prices.length];
        //dp3[i]表示前i天最后一个状态为冷冻期的最大收益（第i天要么无状态即冷冻期后没有再买入，要么为冻结状态）
        int[] dp3 = new int[prices.length];
        
        dp1[0] = 0 - prices[0];
        for(int i = 1; i < prices.length; i++) {
            //第i天买入股票：dp3[i - 1] - prices[i]（dp3[i - 1]表明今天可以买）
            //第i天不买入股票：dp1[i - 1]
            dp1[i] = Math.max(dp3[i - 1] - prices[i], dp1[i - 1]);
            //第i天卖出股票
            dp2[i] = dp1[i - 1] + prices[i];
            //第i天为冷冻期：代表第i-1天卖出股票->dp2[i - 1]
            //第i天为无状态：dp3[i- 1]
            dp3[i] = Math.max(dp2[i - 1], dp3[i - 1]);
        }
        //1.最后一天卖出
        //2.最后一天为冷冻期
        //3.最后一天无状态（冷冻期后没有再买入）
        return Math.max(dp2[prices.length - 1], dp3[prices.length - 1]);
    }
    
    
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int b1 = -prices[0];
        int s2=0, s1=0;
        int b = 0, s = 0;
        for (int i = 0; i < prices.length ; i++) {
            b = Math.max(b1, s2-prices[i]);
            s = Math.max(s1, b1+prices[i]);
            s2 = s1;
            s1 = s;
            b1 = b;
        }
        return Math.max(s,b);
    }
}
