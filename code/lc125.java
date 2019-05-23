package code;
/*
 * 125. Valid Palindrome
 * 题意：判断是否为回文
 * 难度：Easy
 * 分类：Two Pointers, String
 * 思路：两个指针。另一种是正则表达式替换数字，字母为空格，再反转，判断是否相等。
 * Tips：记下另一种方法。第一种方法Bingo!
 *       lc234, lc5
 */
public class lc125 {
    
     public boolean isPalindrome(String s) {
        
        int l = 0, r = s.length()-1;
         // 注意啦
         s = s.toLowerCase();  
        while(l < r){
          
            // 是
            while(l < r && !isZiMu(s.charAt(l)))
                l++;
            while(l < r && !isZiMu(s.charAt(r)))
                r--;
            
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--; 
        }
        return true;
    }
    
    public boolean isZiMu(char a){
        return (a >= 'a' && a <= 'z') ||  (a >= '0' && a <= '9');
    }
    
    -------------------------------
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
    public static boolean isPalindrome(String s) {
        int begin = 0;
        int end = s.length()-1;
        s = s.toLowerCase();    //转为小写
        while(begin<end && !(helper(s.charAt(begin)))) begin++;
        while(begin<end && !(helper(s.charAt(end)))) end--;
        while(begin<end){
            if(s.charAt(begin)==s.charAt(end)){
                begin++;
                end--;
                while(begin<end && !(helper(s.charAt(begin)))) begin++;
                while(begin<end && !(helper(s.charAt(end)))) end--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static boolean helper(Character ch){ //过滤非字符数字
        if(Character.isAlphabetic(ch)||Character.isDigit(ch)) return true;
        return false;
    }

    public boolean isPalindrome2(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
}
