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
    
      //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        //用来记录窗口内的字符是否出现过
        Set<Character> set = new HashSet();
        
        int l = 0 , r = -1;
        int res = 0;
        while(r < s.length()){
            //一定要break, 一是防止越界，二是不然L不会break； R你都到str.length - 1，L你要再移动也不会更长了
            if(r == s.length() -1) 
                break;
            //右指针一直走，遇到出现过的左指针走，直到遇到出现过的那个字母
            if(!set.contains(s.charAt(r+1))){
                set.add(s.charAt(++r));
            }else{
                set.remove(s.charAt(l++));
            }
            res = Math.max(res, r - l +1);
        }
        
        return res;
    }
    
    
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
