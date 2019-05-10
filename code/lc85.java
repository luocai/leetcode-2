package code;

import java.util.Stack;

/*
 * 85. Maximal Rectangle
 * 题意：为1的组成的最大矩形面积
 * 难度：Hard
 * 分类：Array, Hash Table, Dynamic Programming, Stack
 * 思路：将问题转化为 84.Largest Rectangle in Histogram
 * Tips：很难，lc84就够难了，没写过的谁能想到。。。
 */
public class lc85 {
    // 单调栈
    class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int maxArea = 0;
        int[] height = new int[matrix[0].length];  //依次的求每一行的直方图最大面积
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1; //有点dp的意思, 如果是1的话就是上面的height[j] + 1
            maxArea = Math.max(largestRectangleArea(height), maxArea); // 计算以当前行作为底的最大矩形
        }
        return maxArea;
    }
    // 这个就是 LeetCode - 84的代码
    public int largestRectangleArea(int[] h) {
        if (h == null || h.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < h.length; i++) {
            while (!stack.isEmpty() && h[i] <= h[stack.peek()]) {
                int top = stack.pop();
                int L = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, (i - L - 1) * h[top]);//注意i自己就是右边界  左边界到右边界中间的格子(i-L-1)
            }
            stack.push(i); //注意是下标入栈
        }
        //处理完整个数组之后，再处理栈中的
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int L = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, (h.length - 1 - L) * h[top]);//注意所有还在栈中的右边界都是 数组的长度右边没有比它小的
        }
        return maxArea;
    }
}
    
    
    
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},
                          {'1','0','1','1','1'},
                          {'1','1','1','1','1'},
                          {'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }
    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)
            return 0;
        int col = matrix[0].length;
        int[] row = new int[col];   // 用来记录直方图高度
        int res =0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < col ; j++) {
                if(matrix[i][j]=='0')
                    row[j] =0;
                else
                    row[j] = row[j]+1;
            }
            // 求直方图最大面积
            Stack<Integer> st = new Stack();
            for (int j = 0; j <= col ; j++) {
                int h = ( j==col ? 0 : row[j] );
                if(st.isEmpty() || h>row[st.peek()]){
                    st.add(j);
                }else{
                    int index = st.pop();
                    res = Math.max(res, row[index]*(j- ( st.isEmpty() ? -1 : st.peek() ) -1));
                    j--;
                }
            }
        }
        return res;
    }
}
