package code;
/*
 * 91. Decode Ways
 * 题意：1~26代表了26个字母
 * 难度：Medium
 * 分类：String, Dynamic Programming
 * 思路：动态规划，和上台阶问题很像
 * Tips：Bingo!
 */
public class lc91 {
    // 超级经典的
     public int numDecodings(String s) {
        
        if(s.length() == 0)
            return 0;
        
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        
        if(s.charAt(0) == '0')
            return 0;
        else
            dp[1] = 1;
        
        // 对s的每个字符， 除了判断它的前两位外，还会判断当前位
        for(int i = 2; i <= s.length() ;i++){
            
            int a = s.charAt(i-2) - '0';
            int b = s.charAt(i-1) - '0';
            
            
            if((a*10+b) <= 26 && (a*10+b) >= 10)
                dp[i] += dp[i-2];
            
            // 如果是 10 20 这种， 那么这里就不会执行
            // i+1位的时候， 上面那个判断就不会执行，如果此时 i+1 为0，就返回0
            if(b > 0 && b <= 9)
                dp[i] += dp[i-1];
            
            //解析错误，无法解码
            if(dp[i] == 0)
                return 0;
        }
        
        return dp[s.length()];
    }
    
    
    
    
    --------------------------------
    public static void main(String[] args) {
        System.out.println(numDecodings("99"));
    }
    public static int numDecodings(String s) {
        if(s.length()==0) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        int ch = s.charAt(0)-'0';
        if( ch<1 || ch>9 ) return 0;    //判断第一个字符是否符合规范
        else dp[1] = 1;
        for (int i = 2; i < s.length()+1 ; i++) {
            int a = s.charAt(i-2)-'0';
            int b = s.charAt(i-1)-'0';
            if( (a*10+b)<=26 && (a*10+b)>=10 )  //可能存在两个字符10符合，但一个字符0不符合的情况，所以+=
                dp[i] += dp[i-2];
            if( b>0 && b<=9 )
                dp[i] += dp[i-1];
            if(dp[i]==0) return 0;  //解析错误
        }
        return dp[s.length()];
    }
}
