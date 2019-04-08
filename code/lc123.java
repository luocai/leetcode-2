package code;
/*
 * 122. Best Time to Buy and Sell Stock III
 * 题意：买卖股票最大利润，只能买卖2次
 * 难度：Hard
 * 分类：Array, Dynamic Programming
 * 思路：两种思路，第一种是分成两块，每块按lc121的算法进行计算，最后合并结果
 *      第二种思路设置4个变量，分别为第一次买，第一次卖，第二次买，第二次卖的价格
 * Tips：只想到了O(N^2)的方法
 *      lc121, lc309, lc188, lc123, lc714
 */
public class lc123 {
    
    // 分为两部分  0..i   i...n ，每一部分可以转换成
    public int maxProfit(int[] prices) {
        
		if(prices == null || prices.length == 0){
			return 0;
		}
		int maxp = 0;
		for(int i = 0; i < prices.length ;i++){
			
			maxp = Math.max(maxp,solution(prices,0,i)+solution(prices,i, prices.length));
		}
		
		return maxp;
    }

	public int solution(int[] prices, int i, int j){
		
		int pre = prices[i];
		int profit = 0;
		for(int x = i+1; x< j;x++){
			
			if(prices[x] < pre ){
				pre = prices[x];
			}
			
			if(prices[x] - pre > profit){
				profit = prices[x] - pre;
			}
			
		}
		
		return profit;
	}
	
}
