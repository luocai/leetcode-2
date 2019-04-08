package code;
/*
 * 122. Best Time to Buy and Sell Stock II
 * 题意：买卖股票最大利润，可以买多次
 * 难度：Easy
 * 分类：Array, Greedy
 * 思路：计算 prices[i] 与 prices[i-1] 的差值，把正数全加起来就行了
 * Tips：lc121, lc309, lc188, lc123, lc714
 */
public class lc122 {
    
    public int maxProfit(int[] prices) {
        
        if(prices.length ==0)
            return 0;
        
        int pre = prices[0]; // 下一次交易的开始，在次之前的是已经完成的。表示暂定买的股票
        
        int profit = 0;
        
        for(int i = 1 ; i< prices.length ;i++){
            
            if(prices[i] <= pre){
                pre = prices[i]; // 如果当前比上一次的便宜， 则暂定买这个
            }else{
                // 如果当前股票比暂定买的贵，说明可以卖， 则一直往前走，选择利润最大的 
                while(i < prices.length-1 && prices[i] < prices[i+1]){
                    i++;
                }
                
                //计算利润
                profit = profit + (prices[i]-pre);
                if(i < prices.length-1){
					pre = prices[i+1];
				}
				
            }
            
        }
        
        return profit;
    }
}
