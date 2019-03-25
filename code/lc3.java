package code;
/*
* 3. Longest Substring Without Repeating Characters
* 题意：找出字符串中没有重复子串的最大长度
* 难度：Medium
* 分类：Hash Table, Two Pointers, String
* 算法：两个指针，记录没有重复字母的子串的首和尾
*/
import java.util.HashMap;

public class lc3 {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }
    
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口 ， r一直走，如果遇到重复， l向前走
        Map<Character,Integer> map = new HashMap();
        int res = 0;
        int l = 0, r = 0;
        
        while( r < s.length()){
            
            if(map.containsKey(s.charAt(r))){
                l = Math.max(map.get(s.charAt(r))+1, l); //如果 这个字符在 j之前出现了，不管
            }
            
          
            res = Math.max(r-l +1, res);
            map.put(s.charAt(r), r); // //记录某个字符最后出现的位置
              r++;
            
        }
       
        return res;
    }

    
}
