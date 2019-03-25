package code;
/*
 * 22. Generate Parentheses
 * 题意：正确括号组合的
 * 难度：Medium
 * 分类：String, Backtracking
 * 思路：回溯法的典型题目，按选优条件向前搜索，达到目标后就退回一步或返回
 * 注意：递归法别忘了两块的拼接，例如n=4时，可以由2，2拼起来作为答案
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis2(4));
    }

    //回溯法
     List<String> res = new ArrayList();
    public List<String> generateParenthesis(int n) {
        solution(n , n, "");
        
        return res;
    }
    
    public void solution(int a, int b, String r){
        
        if(a > b || a < 0 || b < 0)
            return;
        
        if(a == 0 && b == 0){
            res.add(r);
        }
        
        String t = r + "(";
        solution(a-1, b, t);
        t = r + ")";
        solution(a, b -1, t);
        
    }
    
    
    //这也是回溯啦，不是我写的
    public static List<String> generateParenthesis2(int n) {
        //回溯法
        ArrayList<String> res = new ArrayList<>();
        backtracking(res,"", 0, 0, n);
        return res;
    }

    public static void backtracking(List<String> list,String str,int left, int right, int max){
        if(right==max){
            list.add(str);
        }
        if(left<max)
            backtracking(list,str+"(",left+1,right,max);
        if(right<left)
            backtracking(list,str+")",left,right+1,max);
    }


}
