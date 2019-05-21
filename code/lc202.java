package code;
/*
 * 202. Happy Number
 * 题意：各位置上的数字循环求平方和，如果可以等于1，则为Happy Number
 * 难度：Easy
 * 分类：Hash Table, Math
 * 思路：如果不会等于1，则会产生循环，用hashset记录之前是否出现过
 *      也可利用判断链表是否有环的思路，一个计算一步，一个计算两步，看是会相等来判断
 * Tips：
 */
import java.util.HashSet;

public class lc202 {
    
     // 如果不是快乐数， 则肯定会重复出现，所以用一个set进行记录即可
    public boolean isHappy(int n) {
        
        Set<Integer> set = new HashSet();
        
        while(true){
            if(n == 1)
                return true;
            
            if(set.contains(n))
                return false;
            set.add(n);
            n = cal(n);
        }
        
    }
    
    
    public int cal(int n){
        int res = 0;
        while(n > 0){
            int t = n % 10;
            res += t*t;
            n = n / 10;
        }
        return res;
    }
    
    ------------------------------------
    public boolean isHappy(int n) {
        HashSet hs = new HashSet<Integer>();
        hs.add(n);
        int sum = 0;
        while(true){
            sum = 0;
            while(n!=0){
                sum += Math.pow(n%10,2);
                n = n/10;
            }
            if(sum==1) return true;
            else if(hs.contains(sum)) break;
            hs.add(sum);
            n = sum;
            System.out.println(sum);
        }
        return false;
    }
}
