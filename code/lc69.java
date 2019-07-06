package code;
/*
 * 69. Sqrt(x)
 * 题意：返回x的平方根, int取整
 * 难度：Easy
 * 分类：Math, Binary Search
 * 注意：返回的值是向下取整
 */
public class lc69 {
    
     public int mySqrt(int x) {
        
        //l是1不是0
        int l = 1, r = x;
        
        // 是<= 注意哦
        while(l <= r){
            int m = l + (r - l) / 2;
            
            if(m == x / m)
                return m;
            else if(m > x / m){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        // r = m -1 表示向下取整
        return r;
    }
    
    ------------------------
        
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        int left = 1, right = x;
        while(left<=right){ // 等于时继续循环，保证向下取整
            int mid = (left + right)/2;
            if(mid==x/mid)
                return mid;
            else if(mid>x/mid)
                right = mid - 1;
            else
                left = mid + 1;
        }
        // 返回的是 right = mid-1 保证向下取整
        return right;
    }
}
