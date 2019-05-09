package code;
/*
 * 581. Shortest Unsorted Continuous Subarray
 * 题意：找出数组中需要排序的长度
 * 难度：Easy
 * 分类：Array
 * 思路：从左到右循环，记录最大值为 max，若 nums[i] < max, 则表明位置 i 需要调整, 循环结束，记录需要调整的最大位置 i 为 high;
    同理，从右到左循环，记录最小值为 min, 若 nums[i] > min, 则表明位置 i 需要调整，循环结束，记录需要调整的最小位置 i 为 low.
 * Tips：直接写出来的
 */
public class lc581 {
    
    //
    public int findUnsortedSubarray(int[] nums) {
        
        if(nums.length < 2)
            return 0;
        
        // 分别为左边需要排序的最小坐标， 右边需要排序的最大坐标
        int low = 0, high = 0;
        
        int max = nums[0];
        
        //从左到右循环，记录需要调整的最大位置 high
        for(int i = 1; i < nums.length ;i++){
            if(nums[i] < max)  // 当前值小于左边的最大值，说明 i 需要调整 （hign右边的是不需要调整的）
               high = i;
            if(nums[i] > max)
                max = nums[i];
        }
        
        int min = nums[nums.length - 1];
        
        //从右到左循环，记录需要调整的最小位置 low
        for(int i = nums.length-2; i >= 0 ; i--){
            if(nums[i] > min) // 当前值大于右边的最小值，说明i需要调整 （i左边的是不要调整的）
                low = i;
            if(nums[i] < min)
                min = nums[i];
        }
        
        return low == high ? 0 : high - low +1;
    }
    
    
    
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length<2)
            return 0;
        int left =0, right = 0;
        int temp = nums[nums.length-1];
        for (int i = nums.length-2; i >=0 ; i--) {
            if(nums[i]>temp) left = i;          //小于最小值就不用排序了，大于的话记录一下
            if(nums[i]<temp) temp = nums[i];    //记录最小值
        }
        temp = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            if(nums[i]<temp) right = i;     //找right
            if(nums[i]>temp) temp = nums[i];
        }
        return left==right? 0 : right-left+1;
    }
}
