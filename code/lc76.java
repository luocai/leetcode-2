package code;
/*
 * 76. Minimum Window Substring
 * 题意：字符串s中找出能包含t所有字母的最短串
 * 难度：Hard
 * 分类：Hash Table, Two Pointers, String
 * 思路：两个指针，移动右指针使得满足条件，移动左指针缩短距离。用hashmap存储进行判断是否满足条件。
 * Tips：很难的题，思路记一下。
 *      https://leetcode.com/problems/minimum-window-substring/discuss/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems
 *      和lc3也坐下对比
 */
import java.util.HashMap;

public class lc76 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
     // 滑动窗口模型
    // 思路：右指针一直往前走，直到遇到所有字符匹配成功
    // 匹配成功后 左指针向前走，然后继续上面的操作
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> map = new HashMap();
        
        // 统计 t中每个字符出现的次数
        for(int i = 0; i < t.length() ;i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), map.get(t.charAt(i))+1);
            }else{
                map.put(t.charAt(i), 1);
            }
        }
        
        int left = 0, right = 0;  // 窗口的左右指针
        int res_left = 0 , res_len = s.length() + 1; // 最短子串结果的左指针， 长度
        int count = 0; // 当前匹配了多少个字符
        while(right < s.length()){
            char c =s.charAt(right);
            
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1); // 使用了一次就次数减一
                if(map.get(c) >= 0) // 这个等号很关键
                    count++;
            }
            
            while(count == t.length()){
                if(right - left + 1  < res_len) // 更新res
                {
                    res_len = right - left + 1;
                    res_left = left;
                }
                char tc = s.charAt(left);
                
                if(map.containsKey(tc)){
                    map.put(tc, map.get(tc)+1); // 该字符不用了，放回去
                    if(map.get(tc) > 0)
                        count--; // 匹配数也要减一， 然后会跳出循环..
                }
                left++;
            }
            right++;
        }
        if(res_len == s.length()+1)
            return "";
        
        return s.substring(res_left, res_left+ res_len);
    }
}
