package code;
/*
 * 44. Wildcard Matching
 * 题意：通配符匹配
 * 难度：Hard
 * 分类：String, Dynamic Programming, Backtracking, Greedy
 * 思路：二维dp，和lc10很像，比lc10要简单一些。空间还可以压缩。
 * Tips：bingo
 */
public class lc44 {
    
    // dp[i][j] 表示 s的i 到 p的j是否匹配
    public boolean isMatch(String s, String p) {
      // abdbesc
      // ab*c
           
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        
        //空串匹配
        dp[0][0] = true;
        
        // 只有p是以* 开头， 空串才和她匹配
        for(int i = 0; i < p.length() ; i++){
            if(p.charAt(i) == '*')
                dp[0][i+1] = true;
            else
                break;
        }
        
        // 注意 i-1才表示当前字符
        for(int i = 1; i<= s.length() ; i++){
            for(int j = 1; j <= p.length() ; j++){
                
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j-1] || dp[i-1][j] || dp[i][j-1];
                    //dp[i-1][j-1]  *任意第一个字符
                    //dp[i-1][j]  *匹配后续任意
                    //dp[i][j-1]  *匹配空
                }
            }
        }
        
        return dp[s.length()][p.length()];   
    }
    
    -----------------------------------
        
    public static void main(String[] args) {
        System.out.println(isMatch("cb","?b"));
    }
    
    // abdbesc
    // ab*c
    // dp[1][1] t
    //  2 2 t
    // 3 3 t
    // 3 4 t
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        char[] s_ch = s.toCharArray();
        char[] p_ch = p.toCharArray();
        for (int i = 0; i < p.length() ; i++) {
            if(p_ch[i]=='*') dp[0][i+1]=true;
            else break;
        }
        for (int i = 1; i <= s.length()  ; i++) {
            for (int j = 1; j <= p.length() ; j++) {
                if(s_ch[i-1]==p_ch[j-1] || p_ch[j-1]=='?') dp[i][j] = dp[i-1][j-1];
                if(p_ch[j-1]=='*') dp[i][j] = dp[i-1][j-1] || dp[i-1][j] || dp[i][j-1];
                //dp[i-1][j-1]  *任意第一个字符
                //dp[i-1][j]  *匹配后续任意
                //dp[i][j-1]  *匹配空
            }
        }
        return dp[s.length()][p.length()];
    }
}
