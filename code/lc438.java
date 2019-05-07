package code;
/*
 * 438. Find All Anagrams in a String
 * 题意：匹配相同字符组成的串
 * 难度：Easy
 * 分类：Hash Table
 * 思路：滑动窗口，O(n)时间
 * Tips：滑动窗口解法 https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem
 * lc76类似
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc438 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
    
    
    
    // 滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList();
        if(s.length() < p.length())
            return res;
        
        //计算p中各个字符的数量
        int[] pdic = new int[26];
        for(char c : p.toCharArray()){
            pdic[c-'a']++;
        }
        
        //计算窗口各个字符的数量，窗口大小==p的长度（此时是p长度-1，在向右移动的时候维持p的长度）
        int[] swindow = new int[26];
        for(int i = 0; i < p.length()-1 ;i++){
            swindow[s.charAt(i)-'a']++;
        }
        
        //让窗口向右移动，每次移动一格
        for(int i = p.length()-1; i < s.length() ;i++){
            swindow[s.charAt(i)-'a']++;
            if(isSame(pdic,swindow)){
                res.add(i-p.length()+1);
            }
            //左边界的字符删除
            int edge = i-p.length() + 1;
            swindow[s.charAt(edge)-'a']--;
        }
        
        return res;
    }
    
    public boolean isSame(int[] a, int[] b){
        for(int i = 0; i < a.length ;i++){
            if(a[i] != b[i])
                return false;
        }
        return true;
    }
    
    
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls = new ArrayList<>();
        if(s.length()<p.length())
            return ls;
        HashMap<Character, Integer> hm = new HashMap();
        for (int i = 0; i < p.length() ; i++) {
            hm.put(p.charAt(i), hm.getOrDefault(p.charAt(i), 0)+1);
        }
        int right = 0, left = 0, count = 0;
        while(right<s.length()){
            char ch_r = s.charAt(right);
            char ch_l = s.charAt(left);
            if(hm.containsKey(ch_r)){
                hm.put(ch_r, hm.getOrDefault(ch_r,0)-1);
                if(hm.get(ch_r)>=0) //注意count++的条件，多余的相同字符不用++了
                    count++;
            }
            if(count==p.length())
                ls.add(left);
            if(right-left+1==p.length()){   //左指针需要右移
                if(hm.containsKey(ch_l)){
                    hm.put(ch_l, hm.get(ch_l)+1);
                    if(hm.get(ch_l)>0)  //count--的条件
                        count--;
                }
                left++;
            }
            right++;
        }
        return ls;
    }
}
