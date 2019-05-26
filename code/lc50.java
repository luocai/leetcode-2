package code;
/*
 * 50. Pow(x, n)
 * 题意：幂运算
 * 难度：Medium
 * 分类：Math, Binary Search
 * 思路：和lc29的思路类似，数值上的二分。用前一步的结果进行下一步的运算，降低了迭代次数
 * Tips：注意溢出的情况，负数的情况。
 */
public class lc50 {
    // 类似二分
    public double myPow(double x, int n) {
        
        if(n == 0)
            return 1;
        
        // 特殊情况
        if(n==Integer.MIN_VALUE && x!=1 && x!=-1)
            return 0;
        
        // 如果n是负数，则变成小数
        if(n < 0){
            n = -n;
            x = 1/ x; 
        }
        
        // 如果幂是 2的倍数， 则x变成平方， n除以2
        // 如果幂不是2的倍数， 则给它乘x，让他变成2的倍数
        if( n % 2 == 0)
            return myPow(x*x, n / 2);
        else
            return x*myPow(x*x, n / 2);
    }
    
    ---------------------
        
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n==Integer.MIN_VALUE && x!=1 && x!=-1) return 0;
        if(n<0){
            n = -n;
            x = 1/x;    //负数变成 1/x
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}
