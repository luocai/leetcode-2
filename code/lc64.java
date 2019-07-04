package code;
/*
 * 64. Minimum Path Sum
 * 题意：求矩阵和最小的路径
 * 难度：Medium
 * 分类：Array, Dynamic Programming
 * 思路：和lc63, lc62思路一样, arr存储的内容由路径数换成了和
 */
public class lc64 {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
    
     public int minPathSum(int[][] grid) {
        
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        
        for(int i = 1; i < dp.length; i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        
        for(int i = 1; i < dp[0].length; i++){
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }
        
        for(int i = 1; i< dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
    }

    //dp  dp[i][j] 表示 （0,0）到（i,j）的最小值
    // dp[i][j] = min(dp[i-1][j],dp[i][j-1])+ grid[i][j]
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                if(i==0 && j==0)
                    arr[i][j] = grid[i][j];
                else if(i==0)
                    arr[i][j] = arr[i][j-1] + grid[i][j];
                else if(j==0)
                    arr[i][j] = arr[i-1][j] + grid[i][j];
                else
                    arr[i][j] = Math.min(arr[i-1][j],arr[i][j-1]) + grid[i][j];
            }
        }
        return arr[m-1][n-1];
    }
}
