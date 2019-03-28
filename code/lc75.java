package code;
/*
 * 75. Sort Colors
 * 题意：重排序，数组中只有0,1,2
 * 难度：Medium
 * 分类：Array, Two Pointers, Sort
 * 思路：两个指针，尾指针放2，头指针放1
 * Tips：一个for循环就可以了，注意避免自己与自己交换，造成l>i
 */
public class lc75 {
    
    // O(N), 还有一种解法是统计 一轮遍历统计 0 1 2的个数
      public void sortColors(int[] nums) {
        
        int l = 0, r = nums.length-1, i =0;
        
        while(i <= r){
            
            if(nums[i] == 0){
                // 前面的i都是 ok了的，所以可以++
                swap(nums,l++, i++);
            }else if(nums[i] == 2){
                //后面的i可能有0，1，所以换了之后还不能++
                swap(nums,r--, i);
            }else{
                i++;
            }
            
        }
    }
    
    public void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
