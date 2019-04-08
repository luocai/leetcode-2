package code;

import java.util.HashSet;
import java.util.Set;

/*
 * 128. Longest Consecutive Sequence
 * 题意：无序数组，求最长连续子序列的长度
 * 难度：Hard
 * 分类：Array, Union Find
 * 思路：用set先把所有元素放一遍，再遍历，每次找边界，remove掉
 * Tips：也可以只用一个循环，每次放进去以后，更新边界的值即可
 */
public class lc128 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
    /*
    * 将所有的元素装入hash Set
    * 遍历元素 如果（前一个数不在set）中 往后找最大序列的长度
    * 如果不是lower Bound 跳过即可。
    * 这样每个元素只会变访问两次 
    */
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet();
        int res = 0;
        for(int i = 0; i< nums.length; i++){
            set.add(nums[i]);
        }
        
        for(int i = 0; i < nums.length;i++){
            
            // 如果前一个数不在set中，则往后找最大序列的长度
            if(!set.contains(nums[i]-1)){
                
                int nextNum = nums[i]+1;
                int count = 1;
                
                while(set.contains(nextNum)){
                    count++;
                    nextNum++;
                }
                if(count > res){
                    res = count ;
                }
            }
            
        }
        return res;
    }
}
