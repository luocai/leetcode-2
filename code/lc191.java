package code;
/*
 * 191. Number of 1 Bits
 * 题意：统计二进制数中1的个数
 * 难度：Easy
 * 分类：Bit Manipulation
 * 思路：每次移一位，与运算
 * Tips：
 */
public class lc191 {
    // you need to treat n as an unsigned value
    
    public int hammingWeight(int n) {
        
        //00000000000000000000000000001011
        //00000000000000000000000000001010
       int count = 0;
        while(n != 0)
        {
            count++;
            // 使用 n=n&(n-1) 可以除去最左边的1  可以避免无效的移位
            // 每减一位可以 得到一个不同的
            n=n&(n-1);
        }
        return count;
    }
    
    
    -----------------------
    public int hammingWeight(int n) {
        int sum = 0;
        int a = 1;
        while(a!=0){
            int b = n&a;
            if(b!=0) sum += 1;
            a <<= 1;
        }
        return sum;
    }
}
