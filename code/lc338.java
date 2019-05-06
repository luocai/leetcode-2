package code;
/*
 * 338. Counting Bits
 * 题意：0~n数字上1的个数
 * 难度：Medium
 * 分类：Dynamic Programming, Bit Maniputation
 * 思路：把前几个数的二进制写出来，就很容易看出来dp公式，前边的值+1即可
 * Tips：注意细节，边界情况
 */
public class lc338 {
    //dp[i] = dp[i>>1] + i % 2;
    // 1011
    // 101
    // 如果i是偶数，那么 和i>>1 一样的位数 ， 否则就比他多一位 
    public int[] countBits(int num) {
        
        int[] dp = new int[num+1];
        dp[0] = 0;
        
        for(int i = 1; i <= num ;i++){
            dp[i] = dp[i>>1] + i % 2;
        }
        return dp;
    }
    
    
    public static int[] countBits(int num) {
        int[] dp = new int[num+1];
        int i = 1;
        while(i<=num) {
            dp[i] = 1;
            int max = i;
            for (int j = 0; j<max && i<=num ; j++) {
                dp[i] = 1 + dp[j];
                i++;
            }
        }
        return dp;
    }
}
