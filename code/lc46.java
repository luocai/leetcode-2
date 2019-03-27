package code;

import java.util.ArrayList;
import java.util.List;

/*
 * 46. Permutations
 * 题意：全排列
 * 难度：Medium
 * 分类：Backtracking
 * 思路：典型的回溯题,注意判断下相同元素重复添加,和lc39,lc78做比较
 */
public class lc46 {
    
    //典型的回溯问题
    List<List<Integer>> res = new ArrayList();
    List<Integer> tres = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        
        solution(nums);
        
        return res;
    }
    
    public void solution(int[] nums){
        
        if(tres.size() == nums.length){
           
            res.add(new ArrayList(tres));
           
            return;
        }
        
        for(int i = 0; i < nums.length;i++){
            
            if(tres.contains((Integer)nums[i])) //判断是否已经包含
                continue;
            
            tres.add(nums[i]);
            solution(nums);
            tres.remove((Integer)nums[i]);
            
        }
        
    }
}
