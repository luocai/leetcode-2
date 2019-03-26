package code;

import java.util.ArrayList;
import java.util.List;

/*
 * 39. Combination Sum
 * 题意：找出和为sum的所有组合
 * 难度：Medium
 * 分类：Array, Backtracking
 * 思路：回溯法
 * Tips：向res添加答案时注意要new一个新的List,否则后续循环的操作会影响res中的L; 设置一个start标志，记录上次数组循环到哪了,防止重复集合。
 * 和lc46,lc78做比较，46是排列组合，所以不需要start标志，start标志是为了防止相同元素的组合排列不同而当做了另一种
 */
public class lc39 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target).toString());
    }
    
    //回溯法
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
		List<List<Integer>> result = new ArrayList();
		Arrays.sort(candidates);
		
		solve(result, new ArrayList<>(), 0,candidates, 0,target);
		
		return result;
    }
	
    //回溯
	public void solve(List<List<Integer>> result,List<Integer> res,int sum,int [] canditates,int index, int target){
		
		if(sum == target){
			result.add(new ArrayList<Integer>(res)); //记得要new一个
			return;
		}
		
		if(sum > target || index >= canditates.length || canditates[index] > target){
			return;
		}
		
		res.add(canditates[index]);  // 选
		solve(result, res, sum+canditates[index],canditates, index, target);
		res.remove(res.size()-1);   // 不选
		solve(result, res, sum, canditates, index+1, target);
		
	}
}
