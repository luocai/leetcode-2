package code;
/*
 * 155. Min Stack
 * 题意：设计一个栈，这个栈有一个getmin方法
 * 难度：Easy
 * 分类：Stack, Design
 * 思路：每次替换最小值时，把当前最小值入栈用以记录，以便之后更新最小值
 * Tips：
 */
import java.util.Stack;

class MinStack {
    
    LinkedList<Integer> stack ;
    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList();
    }
 
    public void push(int x) {
        //记录上一个最小值， 如果当前最小值被弹出了，可以找到第二小的值
        if(x <= min){
            stack.push(min);
            this.min = x;
        }
        stack.push(x);
       
    }
    
    public void pop() {
        int x = stack.pop();
        if( x == min){
            min = stack.pop(); // 记录了第二小的值，可以直接拿到
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
