package code;
/*
 * 5. Longest Palindromic Substring
 * 题意：找出给定字符串中最长的回文串
 * 难度：Medium
 * 分类：String, Dynamic Programming
 * Tips：从后往前遍历，保证后续dp时，子情况已计算出
 *       还有一种思路是从中间往两边扩展，中间有两种情况，一种一个字符，一种两个字符
 */
public class lc5 {
    
    // dp[i][j] 表示 i...j是回文子串
    public String longestPalindrome(String s) {
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";
        
        for(int i = s.length()-1; i >= 0; i--){
            for(int j = i ; j < s.length() ; j++){

                if(s.charAt(i) == s.charAt(j) ){
                    // j-i == 0 说明是同一个位置，true
                    // j-i == 1 说明j 和 i相邻 ， true
                    if((j-i) < 2 || dp[i+1][j-1])  
                        dp[i][j] = true;
                    
                    if((j-i+1) > res.length()){
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }
    
    
    
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        for (int i = n-1; i>=0 ; i--) {
            for (int j = i; j <n ; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    if((j-i)<3 || dp[i+1][j-1])
                        dp[i][j] = true;
                    if(dp[i][j] && j-i+1>res.length())
                        res = s.substring(i,j+1);   // 起始索引，终止索引(不包括，所以+1)
                }
            }
        }
        return res;
    }
}
