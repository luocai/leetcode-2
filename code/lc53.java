package code;
/*
 * 53. Maximum Subarray
 * 题意：最大连续子序列和
 * 难度：Easy
 * 分类：Array, Divide and Conquer, Dynamic Programming
 * 注意：分治方法如何进行merge，merge时，必须包含mid元素，因为是连续子序列
 */
public class lc53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
    }

   // dp  dp[i] 表示以i结尾的最大子序和
    public int maxSubArray(int[] nums) {
        
        if(nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        
        int res = dp[0];
        for(int i = 1; i< nums.length;i++){
            
            //如果以i-1结尾的最大子序和小于0了，那我就不加他了，自立门户..
            if(dp[i-1] >= 0){
                dp[i] = dp[i-1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            if(res < dp[i])
                res = dp[i];
        }
        
        return res;
        
    }
    
    
      // 也是dp ， 做了优化 空间复杂度优化为 o(1)
    public int maxSubArray(int[] nums) {
        
        if(nums.length == 0)
            return 0;
        
        int ans = 0;
        int res = nums[0];
        for(int i = 0;i < nums.length;i++){
            if(ans < 0){
                ans = 0;
            }
            ans += nums[i];
            if(ans > res)
                res = ans;
        }
        return res;
    }
    
    
}
