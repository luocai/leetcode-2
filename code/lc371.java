package code;
/*
 * 371. Sum of Two Integers
 * 题意：两个数相加，但不能用 + - 操作符号
 * 难度：Easy
 * 分类：Bit Maniputation
 * 思路：自己没想起来
 *      https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary%3A-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
 * Tips：
 */
public class lc371 {
    
     //异或这里可看做是相加但是不显现进位，比如5 ^ 3
     /*0 1 0 1
       0 0 1 1
     ------------
       0 1 1 0      
     上面的如果看成传统的加法，不就是1+1=2，进1得0，但是这里没有显示进位出来，仅是相加，0+1或者是1+0都不用进位*/
    
    //相与为了让进位显现出来，比如5 & 3
    /* 0 1 0 1
       0 0 1 1
     ------------
       0 0 0 1
    上面的最低位1和1相与得1，而在二进制加法中，这里1+1也应该是要进位的，所以刚好吻合，但是这个进位1应该要再往前一位，所以左移一位*/
    
    public int getSum(int a, int b) {
       
        
       while(b != 0){
           int sum = a ^ b;
           int carry = (a & b) << 1; //进位
           
           a = sum;
           b = carry;
       }
        return a;
    }
    
    
    -------------------
    public int getSum(int a, int b) {
        return b==0? a:getSum(a^b, (a&b)<<1);   // a^b 为不算进位的结果，加上进位
    }
}
