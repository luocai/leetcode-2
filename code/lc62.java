package code;
/*
 * 62. Unique Paths
 * 题意：求从数组[0,0]走到[m,n]的不同路径数
 * 难度：Medium
 * 分类：Array, Dynamic Programming
 * 思路：和lc63, lc64思路一样, arr存储的内容由路径数换成了和
 */
public class lc62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }

    // dp     dp[i][j] = dp[i-1][j] + dp[i][j-1]
   public int uniquePaths(int m, int n) {

		int[][] dp = new int[m][n];
		
		for(int i = 0;  i < n; i++){
			dp[0][i] = 1;
		}
		for(int i = 0; i < m; i++){
			dp[i][0] = 1;
		}
		
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		return dp[m-1][n-1];
    }
}
