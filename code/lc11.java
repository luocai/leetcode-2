package code;
/*
 * 11. Container With Most Water
 * 题意：数组下标代表横坐标，数组中的值代表纵坐标，求最大面积
 * 难度：Medium
 * 分类：Array, Two Pointers
 * Tips：复杂度可以为O(N), 指针往里走, 若值也小了，则面积一定不会增大。和lc42做比较
 */
public class lc11 {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }

     public int maxArea(int[] height) {
        
        int l = 0, r = height.length - 1;
        
        int res = 0;
        
        while( l < r){
            
            int area = Math.min(height[l],height[r]) * (r-l);
            
            if(area > res){
                res = area;   
            }
            
            //哪个小走哪个，两线段之间形成的区域的高总是会受到其中较短那条高的长度的限制。而且，两线段距离越远，得到的面积就越大。
            if(height[l] > height[r]){
                r--;
            }else{
                l++;
            }
        }
        return res;
    }
}
