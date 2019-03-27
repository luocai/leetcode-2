package code;

import java.util.Stack;

/*
 * 42. Trapping Rain Water
 * 题意：能盛多少水
 * 难度：Hard
 * 分类：Array, Two Pointers, Stack
 * 思路：三种方法:1.DP先求出来每个位置的maxleft,maxright，再遍历一遍;2.两个指针，类似lc11题的思路;3.用栈数据结构;
 * Tips：
 */
public class lc42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        System.out.println(trap2(height));
    }
    
   //思路 先找到最大的柱子，然后以此为界， 分别计算左边和右边的
    // 以计算左边为例： 当 当前高度比left指针高的时候，意味着 要更新left的值了
    // 否则 就把这个格子的容量算上，因为 left挡住了左边，而最高点又在右边，保证可以装水
    public int trap(int[] height) {
        
        
        int maxIndex = 0; 
        int max = 0;
        int res = 0;
        
        //先找最高点
        for(int i = 0;i  < height.length;i++){
            if(max < height[i]){
                max = height[i];
                maxIndex = i;
            }
        }
        
        int left = 0;
        
        //计算左边的容量
        for(int i = 0;i < maxIndex;i++){
            
            if(left > height[i]){
                res = res + (left-height[i]);
            }else{
                left = height[i];
            }
            
        }
        
        //计算右边的容量
        int right = 0;
        for(int i = height.length-1; i > maxIndex;i--){
            
            if(right > height[i]){
                res = res + (right-height[i]);
            }else{
                right = height[i];
            }
            
        }
        
        return res;
        
    }

    public static int trap2(int[] A) {
        //栈方法
        if (A==null) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, maxWater = 0, maxBotWater = 0;
        while (i < A.length){
            if (s.isEmpty() || A[i]<=A[s.peek()]){
                s.push(i++);
            }
            else {
                int bot = s.pop();
                maxBotWater = s.isEmpty()? // empty means no il
                        0:(Math.min(A[s.peek()],A[i])-A[bot])*(i-s.peek()-1);
                maxWater += maxBotWater;
            }
        }
        return maxWater;
    }
}
