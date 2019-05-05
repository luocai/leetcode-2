package code;
/*
 * 283. Move Zeroes
 * 题意：把非0元素移到数组前边，相对位置不变
 * 难度：Easy
 * 分类：Array, Two Pointers
 * 思路：遍历一遍数组，如果这个数非0，就合前边的数字交换
 * Tips：
 */
public class lc283 {
    //遍历一遍，遇到不为0的数字，就和左边第一个为0的交换
    //左边第一个0的左边用 j 表示，不为0 就 
    public void moveZeroes(int[] nums) {
        for (int i = 0, j=0; i < nums.length ; i++) {
            if(nums[i]!=0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}
