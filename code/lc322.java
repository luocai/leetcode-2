package code;
/*
 * 322. Coin Change
 * 题意：不同面额零钱组合成总值，用的零钱数最少
 * 难度：Medium
 * 分类：Dynamic Programming
 * 思路：和lc279一样的思路，注意下没解的情况
 * Tips：不用Set, 加一个dp[0]=0，可以直接递归出结果
 */
import java.util.Arrays;
import java.util.HashSet;

public class lc322 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2}, 3));
    }
    
     //dp[i] 表示兑换金额i最小需要的硬币个数
    //dp[i] = max(dp[i], dp[i-c]+1)
    public int coinChange(int[] coins, int amount) {
        
        if(amount == 0)
            return 0;
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 如果刚好有硬币，则对应为1
        for(int i = 0; i < coins.length; i++){
            if(coins[i] <= amount){
                dp[coins[i]] = 1;
            }
        }
        dp[0] = 0;
        
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                int c = coins[j];
                if(i - c >= 0 && dp[i-c] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-c]+1);
                }
            }
        }
        
        return  dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    
    
    public static int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int[] dp = new int[amount];
        Arrays.fill(dp, Integer.MAX_VALUE);
        HashSet<Integer> s = new HashSet();
        for (int i = 0; i < coins.length ; i++) {
            s.add(coins[i]);
        }
        for (int i = 0; i < amount ; i++) {
            if(s.contains(i+1))
                dp[i] = 1;
            else{
                for (int j = 0; j < coins.length ; j++) {
                    if( i+1-coins[j]>0 && dp[i - coins[j]]!=Integer.MAX_VALUE ) {   // 注意子结构没解的情况
                        dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                    }
                }
            }
        }
        return dp[amount-1]==Integer.MAX_VALUE ? -1 : dp[amount-1];     //没解返回-1
    }
}
