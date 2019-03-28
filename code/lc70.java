package code;
/*
 * 70. Climbing Stairs
 * 题意：上楼梯问题，一次走一步或两步
 * 难度：Easy
 * 分类：Dynamic Programming
 */
public class lc70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

   // dp
  public int climbStairs(int n) {
        
        int[] dp = new int[n];
        
        if(n <= 2)
            return n;
        
        dp[0] = 1;
        dp[1] = 2;
        
        for(int i = 2 ;i < n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n-1];
        
        
    }
    
    // o(1)空间
    public int climbStairs(int n) {
        
        if(n == 1 || n== 2)
            return n;
        int a = 1, b = 2;
        int res = 0;
        for(int i = 3; i <= n;i++){
            res = a + b;
            a = b;
            b = res;
        }
        
        return res;
    }
}
