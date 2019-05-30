package code;
/*
 * 7. Reverse Integer
 * 题意：反转一个整数
 * 难度：Easy
 * 分类：Math
 * 注意：如何判断溢出
 */
public class lc7 {
    public static void main(String[] args) {
        System.out.println(reverse(-987));
    }

     public int reverse(int x) {
        
        int res = 0;
        
        while( x != 0){
            int temp = res * 10 + x % 10;
            
            // 溢出
            if(temp / 10 != res)
                return 0;
            res = temp;
            
            x /= 10;
        }
        
        return res;
    }
}
