package code;
/*
 * 72. Edit Distance
 * 题意：编辑距离
 * 难度：Hard
 * 分类：String, Dynamic Programming
 * 思路：dp[i][j] 可以由 dp[i-1][j], dp[i][j-1], dp[i-1][j-1] 变过来
 * Tips：很经典的题，注意如何初始化dp[0][i]和dp[i][0]，以及dp更新规则。空间复杂度还可以优化。
 */
public class lc72 {
    public static void main(String[] args) {
        System.out.println(minDistance("intention","execution"));
    }
     
    //dp比较经典
    //dp[i][j] 表示 word1 以i 结尾 到word2以j 结尾的最短编辑距离
    public int minDistance(String word1, String word2) {
        
        int m = word1.length(), n = word2.length();
        
        int[][] dp = new int[m+1][n+1];
        
        // wrod1 0..i  到 "" 的最短编辑距离
        for(int i = 0; i <= m;i++)
            dp[i][0] = i;
        // word1 "" 到  Word2 0..1的最短编辑距离
        for(int i = 0; i <= n;i++)
            dp[0][i] = i;
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n;j++){
                
                //
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    
                    // dp[i-1][j-1]+1  替换 word1.charAt(i-1);
                    // dp[i][j-1]+1  删除word1.charAt(i-1) word1向前走一步
                    // dp[i-1][j] + 1 删除word2.charAt(i-1) word2向前走一步  或者 在word这个位置前面插入一个
                    dp[i][j] = Math.min(dp[i-1][j-1]+1, Math.min(dp[i][j-1]+1, dp[i-1][j]+1));
                    
                }
                
            }
        }
        return dp[m][n];
    }
}
