package code;
/*
 * 139. Word Break
 * 题意：是否能够分词
 * 难度：Medium
 * 分类：Dynamic Programming
 * 思路：动态规划
 * Tips：巧妙的方法，防止了复杂的操作，通过遍历之前计算出来的结果
 *       lc140
 */
import java.util.List;

public class lc139 {
    //dp[i] 表示 从 0 到 i是否可以拆分
    // dp[i] = dp[0..j] && s.substring(j,)
    public boolean wordBreak(String s, List<String> wordDict) {
      
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            
            for(int j = 0; j < i; j++){
                
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                }
                
            }
        }
        
         return dp[s.length()]; 
        
    }
    
     //dfs  超时
    public boolean wordBreak(String s, List<String> wordDict) {
        
        return dfs(s, wordDict);
        
    }
    
    public boolean dfs(String s, List<String> wordDict){
        
        if(s.length() == 0)
            return true;
        
        boolean ans = false;
        for(int i = 1;i  <= s.length();i++){
            String t = s.substring(0,i);
          
            if(wordDict.contains(t)){
                ans = ans || dfs(s.substring(i),wordDict);
            }
        }
        return ans;
        
    }
}
