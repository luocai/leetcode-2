package code;
/*
 * 29. Divide Two Integers
 * 题意：不用乘法，除法，取模运算实现除法
 * 难度：Medium
 * 分类：Math, Binary Search
 * 思路：被除数减去除数，除数每次左移一位，也就是*2 来实现类似二分的思想
 * Tips：注意下用long类型，以及溢出的情况，注意符号
 */
public class lc29 {
    
     // 二分位运算
    public int divide(int dividend, int divisor) {
        
        if(divisor==0||dividend==Integer.MIN_VALUE&&divisor==-1) 
            return Integer.MAX_VALUE;  //溢出的话直接返回最小值
        
        //用异或来计算符号是否相同
        boolean flag = (dividend ^ divisor) < 0; 
        
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        
        int res = 0;
        // 100 / 3
        // i = 5,  a / 32 = 3 >= b(3)
        // res = 32   a = a - 3*32 = 4
        // i == 4 3 2 1 0   a / 1  = 4 >= b(3)
        // res = res + 1 = 33  a = a - 3 = 1;
        for(int i= 31; i >= 0; i--){
            if((a >> i) >= b){   // (a / 2^n ) > b
                res += 1 << i;   //  res += 2^n
                a -= b<<i;       //  a = a - 2^n*b
            }
        }
        
        return flag ? -res : res;
    }
    
    
    ---------------------
    public static void main(String[] args) {
        System.out.println(divide(-1010369383,-2147483648));
    }
    public static int divide(int dividend, int divisor) {
        if(divisor==0||dividend==Integer.MIN_VALUE&&divisor==-1) return Integer.MAX_VALUE;  //溢出的话直接返回最小值
        int sign;
        if( (dividend>0&&divisor>0) || (dividend<0&&divisor<0) ) sign = 1;
        else sign = -1;
        long dividend2 = Math.abs((long)dividend);      //注意这要强制转换成long，再取abs
        long divisor2 = Math.abs((long)divisor);
        long div = divisor2;
        long res = 0;   //这里也是long
        int p = 0;
        while( !(div>dividend2 && div==divisor2) ){
            long temp = dividend2 - div;
            if(temp>=0){
                res += Math.pow(2, p);
                p++;
                div = div << 1;
                dividend2 = temp;
            }else{
                div = divisor2;
                p = 0;
            }
        }
        return (int)res*sign;
    }
}
