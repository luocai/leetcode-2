package code;
/*
 * 35. Search Insert Position
 * 题意：找到数组中 target 插入的位置
 * 难度：
 * 分类：Array, Binary Search
 * 思路：二分查找
 * Tips：
 */
public class lc35 {
    
    //二分，注意 判断条件的等号，别忘啦
    public int searchInsert(int[] nums, int target) {
        
        int l = 0, r = nums.length-1;
        
        // 等号特别注意
        while(l <= r){
            int m = (l +r) / 2;
            
            if(nums[m] > target){
                r = m-1;
            }else if(nums[m] < target){
                l = m+1;
            }else{
                return m;
            }
        }
        
        
        return l;
        
    }
}
