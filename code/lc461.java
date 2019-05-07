package code;
/*
 * 461. Hamming Distance
 * 题意：转换为2进制，有几个位置上的值不同，就叫做Hamming distance
 * 难度：Easy
 * 分类：Bit Maniputation
 * 思路：异或运算可以直接得出异或后二进制的结果，再统计1的个数即可
 * Tips：
 */
public class lc461 {
    
    // 位运算
    public int hammingDistance(int x, int y) {
        int res = 0;
        
        for(; x > 0 || y >0 ; x>>=1, y>>=1){
            // 分别计算每一位
            int i = x & 1;
            int j = y & 1;
            if((i ^ j) == 1)
                res++;
        }
        return res;
    }
    
    
    public int hammingDistance(int x, int y) {
        int num = x^y;
        int res = 0;
        while(num>0){
            res += num%2;
            num /= 2;
        }
        return res;
    }
}
