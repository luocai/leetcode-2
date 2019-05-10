package code;

import java.util.Stack;

/*
 * 84. Largest Rectangle in Histogram
 * 题意：直方图中最大矩形面积
 * 难度：Hard
 * 分类：Array, Stack
 * 思路：两种方法：1.用dp找到边界，再遍历一遍; 2.用栈，栈内存索引，保证栈内索引对应的高度是递增的，若减了即找到了右边界，出栈开始计算。因为栈内是递增的，左边界就是上个栈内的元素。若栈为空，左边界就是-1。
 * Tips：和lc42做比较，都可以用栈或者dp来做. 很难，栈的操作很难想到.
 *       和lc42 dp作比较 和lc32栈做比较
 *       lc85
 */
public class lc84 {
 class Solution {
     
    //单调栈 o(n)
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            while (!s.isEmpty() && heights[i] <= heights[s.peek()]){
                int top = s.pop();
                int L = s.isEmpty() ? -1 : s.peek(); //如果左边没有比height[top]小的就是-1
                maxArea = Math.max(maxArea, heights[top] * (i - L - 1));
            }
            s.push(i); //注意是下标入栈
        }
        while(!s.isEmpty()){
            int top = s.pop();
            int L = s.isEmpty() ? -1 : s.peek();
            maxArea = Math.max(maxArea, heights[top] * (heights.length - L - 1)); // 右边没有比height[top]大的,就是右边界height.length
        }
        return maxArea;
    }
}

    
    //方法2  o(n2)
   public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        int maxArea = 0;
        for(int cur = 0; cur < heights.length; cur++){
            if(cur != heights.length - 1 && heights[cur] <= heights[cur+1]) continue;
            int minHeight = Integer.MAX_VALUE;
            for(int i = cur; i >= 0; i--){
                if(heights[i] < minHeight) minHeight = heights[i];
                maxArea = Math.max(maxArea, minHeight * (cur - i + 1));
            }
        }
        return maxArea;
    }
}
