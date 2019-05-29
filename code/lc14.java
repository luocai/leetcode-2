package code;
/*
 * 14. Longest Common Prefix
 * 题意：找最长匹配前缀
 * 难度：Easy
 * 分类：String
 * Tips：可先将字符串排序，之后只比较数组中首和尾字符串即可
 */
import java.util.Arrays;

public class lc14 {
    
    public String longestCommonPrefix(String[] strs) {
        
        if(strs.length < 1)
            return "";
        
        // 字典序排序
        Arrays.sort(strs);
        
        String res = "";
        int i = 0;
        
        //只比较第一位和最后一个串
        String s = strs[0];
        String e = strs[strs.length-1];
        
        while(i < s.length() && i < e.length()){
            if(s.charAt(i) == e.charAt(i))
                i++;
            else
                break;
        }
        
        res = s.substring(0,i);
        
        return res;
        
    }
    
    ---------------------------
        
    public static String longestCommonPrefix(String[] strs) {   //不是最优的方法，多做了比较
        if(strs.length==0)
            return "";
        Arrays.sort(strs);
        char[] str1 = strs[0].toCharArray();
        char[] str2 = strs[strs.length-1].toCharArray();
        int len = Math.min(str1.length,str2.length);
        int i = 0;
        while(i<len){
            if(str1[i] == str2[i])
                i++;
            else
                break;
        }
        return strs[0].substring(0,i);
    }
}
