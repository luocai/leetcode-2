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
    
    //中心拓展法
    //从i位置开始，每个位置都要往左右两边开始扩张，相等就继续扩，不相等就停止，并记录，注意这里的下标的变化，以及边界的处理；
    //这里要注意一个问题就是要同时处理奇回文(如cbabd) 和偶回文(如abbccd)，只需要在扩展的时候扩展两次就可以了。

    private int len = 0;    //记录最长回文的长度
    private int begin = 0; // 记录最长回文的起始位置

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            expand(chs, i, i);        //奇回文  例如 cbabd
            expand(chs, i, i + 1); //偶数回文  例如abbccd
        }
        return s.substring(begin, begin + len);
    }

    private void expand(char[] chs, int L, int R) {
        while (L >= 0 && R < chs.length && chs[L] == chs[R]) { // 往两边扩展
            L--;
            R++;
        }
        // 为什么是r-l-1, 因为上面的判断条件中, l或者r超出了范围或者不满足条件
        // 比如   aabac, 此时L = 0, R = 4, 长度为 R - L - 1，也就是中间的3
        if (R - L - 1 > len) { 
            len = R - L - 1;
            begin = L + 1;
        }
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
