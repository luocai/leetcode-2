package code;
/*
 * 494. Target Sum
 * 题意：给数组中的元素赋加减号，使得和为target的分配方案有几种
 * 难度：Medium
 * 分类：Dynamic Programming, Depth-first Search
 * 思路：可以用递归+mem的方法。也可以转化为0，1背包问题，注意dp的时候把下标移位。另一种方法是转化为子数组的和为(target + sum(nums))/2的问题，求解方法类似lc416
 * Tips：多抽象总结一下相关的问题，如何抽象出背包。对于这个数字，要么+，要么-，就两种情况。https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation
 *       dp[i][j] 表示前i个元素和为j的方案个数
 *       dp[i][j] = dp[i-1][j-nums[j]] + dp[i-1][j+nums[j]] //加减两种方案加起来
 *       lc416, lc494
 */
public class lc494 {
    
    //dp[i]代表的含义是从nums中取数相加和为i时有多少种取法。
    //i=0时，就是说从nums中取数相加和为0时有几种取法，只有一种即一个数也不取，所以dp[0]=1
    // 转化为找到nums的一个子集 P，使得sum(P) = (target + sum(nums)) / 2
    public int findTargetSumWays(int[] nums, int S) {
        
        int sum = 0;
        for(int s : nums){
            sum += s;
        }
        
        if(sum < S || (sum+S) % 2 == 1)
            return 0;
        
        sum = (sum + S) / 2;
        
        int[] dp = new int[sum+1];
        dp[0] = 1;
        
        //背包？？
        for(int i = 0; i < nums.length; i++){
            for(int j = sum; j >= nums[i] ;j--){
                dp[j] += dp[j-nums[i]];
            }
        }
        
        return dp[sum];
    }
    
    
    
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if(S>sum||S<-sum)
            return 0;
        int[] dp = new int[sum*2+1]; //还有0,所以+1
        dp[sum] = 1;
        for (int i = 0; i < nums.length ; i++) {
            int[] dp2 = new int[sum*2+1];
            for (int j = 0; j < dp.length ; j++) {
                if(j+nums[i]<dp.length)     //判断下别越界了
                    dp2[j+nums[i]] += dp[j];       // +=dp[j]  求得是总数
                if(j-nums[i]>=0)
                    dp2[j-nums[i]] += dp[j];
            }
            dp = dp2;
        }
        return dp[S+sum];
    }
}
