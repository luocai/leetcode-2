package code;
/*
 * 268. Missing Number
 * 题意：找出 0~n 中少的那个数
 * 难度：Easy
 * 分类：Array, Math, Bit Manipulation
 * 思路：两种巧妙的方法，时间空间都是O(1)
 *      异或
 *      求和以后，减去所有
 * Tips：lc268 lc448 lc287
 */
public class lc268 {
    
    // 求和 再减去那个值
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        
        return nums.length * (nums.length +1) / 2 - sum;
    }
    
    
    
    public int missingNumber(int[] nums) {
        int res = nums.length*(nums.length+1)/2;
        for(int i:nums) res-=i;
        return res;
    }
    public int missingNumber2(int[] nums) {
        int res = nums.length;  //异或上长度
        for(int i=0; i<nums.length; i++) res^=i^nums[i];
        return res;
    }
}
