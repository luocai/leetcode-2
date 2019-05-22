package code;

import java.util.HashMap;

/*
 * 149. Max Points on a Line
 * 题意：给定多个点，问一条线上最多几个点
 * 难度：Hard
 * 分类：HashTable, Math
 * 思路：每次选出一个点，与其他点匹配。因为斜率是小数，所以用两个整数（双层HashMap）来表示小数。时间O(n^2)
 * Tips：
 */
public class lc149 {
    
    
     // 用二维哈希 存储 （x,y,count） x,y是斜率
    public int maxPoints(int[][] points) {
        
        if(points.length < 3)
            return points.length;
        
       // Map<Integer, Map<Integer, Integer>> map = new HashMap();
        int res = 0;
        
        for(int i = 0; i < points.length - 1; i++){
            // 注意定义的位置
            Map<Integer, Map<Integer, Integer>> map = new HashMap();
            int repeat = 1; // 重复点的个数
            int max = 0;  // 和 i点 斜率在一条线上最多的点
            for(int j = i+1; j < points.length; j++){
                
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                
                if(x == 0 && y == 0){
                    repeat++;
                    continue;
                }
                
                int gcd = getGCD(x, y);
                // 避免除0异常
                if(gcd != 0){
                    x /= gcd;
                    y /= gcd;
                }
                
                // 计算 斜率为 （x/y）的点的个数
                Map<Integer, Integer> map2 = map.getOrDefault(x, new HashMap());
                map2.put(y, map2.getOrDefault(y,0)+1);
                map.put(x, map2);
                
                // 更新max
                max = Math.max(max, map2.get(y));
            }
            res = Math.max(res, max + repeat);
        }
        return res;
            
    }
    
    // 通过最小公因数来存储斜率
    public int getGCD(int x, int y){
        if (y == 0)
            return x;
        return getGCD(y, x % y);
    }
    
    
    
    ---------------------------------------------
    
   //通过保存两个整数除以它们的最大公约数之后的值来代替除法，避免造成精度丢失。
    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
    public int maxPoints(Point[] points) {
        if(points.length<=2) return points.length;
        int res = 0;
        for (int i = 0; i < points.length-1 ; i++) {
            HashMap<Integer, HashMap<Integer, Integer>> hm = new HashMap<>();
            int overlap = 1;
            int max = 0;
            for (int j = i+1; j < points.length ; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if(x==0&&y==0){ //重复点
                    overlap++;
                    continue;
                }
                int gcd = genGCD(x, y);
                if(gcd!=0){ //注意，当一个值为0时，gcd==0
                    x = x/gcd;
                    y = y/gcd;
                }
                HashMap<Integer, Integer> hm2 = hm.getOrDefault(x, new HashMap<Integer, Integer>());
                hm2.put(y,hm2.getOrDefault(y,0)+1);
                hm.put(x,hm2);
                max = Math.max(max, hm2.get(y));
            }
            res = Math.max(res, max+overlap);   //里边循环完了，才知道有几个overlap，所以在循环外加
        }
        return res;
    }

    public int genGCD(int a, int b){
        if(b==0) return a;  //注意和GCD不一样的是这没有比较大小，交换a,b。因为可能有负数
        return genGCD(b, a%b);
    }
}
