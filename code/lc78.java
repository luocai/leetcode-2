package code;
/*
 * 78. Subsets
 * 题意：求数组子集
 * 难度：Medium
 * 分类：Array, Backtracking, Bit Manipulation
 * 思路：回溯法
 * Tips：和lc46,39作比较.要找出子集，所以每次backtracking直接添加进res
 */
import java.util.ArrayList;
import java.util.List;

public class lc78 {
    public static void main(String[] args) {
        int[] nums= {1,2,3};
        System.out.println(subsets(nums).toString());
    }
    
    // 回溯法
    List<List<Integer>> res = new ArrayList();
    List<Integer> tres = new ArrayList();
    
    public List<List<Integer>> subsets(int[] nums) {
        res.add(tres);
        tracing(nums, 0);
        return res;
    }
    
    public void tracing(int[] nums, int s){
        
        if(s == nums.length)
            return;
        
        for(int i = s; i < nums.length; i++){
            // 选，然后不选
            tres.add(nums[i]);
            res.add(new ArrayList(tres));
            tracing(nums, i+1);
            tres.remove((Integer)nums[i]); // 注意 （Integer）
        }
        
    }
    
    
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<>());
        if(nums.length==0)
            return res;
        backtracking(res,nums,new ArrayList(),-1);
        return res;
    }
    public static void backtracking(List<List<Integer>> res, int[] nums, List l, int start){
        if(start>=nums.length)
            return;
        for (int i = start+1; i < nums.length ; i++) {
            l.add(nums[i]);
            res.add(new ArrayList<Integer>(l));
            backtracking(res,nums,l,i);
            l.remove((Integer)nums[i]);
        }
    }
}
