package code;

import java.util.HashMap;

/*
 * 560. Subarray Sum Equals K
 * 题意：子数组的和等于k的个数
 * 难度：Medium
 * 分类：Array, Hash Table
 * 思路：求出累加和存在hashmap中，如果当前hashmap中存在sum-k，那么就是一个解
 * Tips：经典思路，记一下。lc437有类似思想。
 *       lc303, lc437, lc560
 */
public class lc560 {
    
    //求出累加和存在hashmap中，如果当前hashmap中存在sum-k，那么就是一个解
    public int subarraySum(int[] nums, int k) {
       
        Map<Integer, Integer> map = new HashMap();
        // 如果sum == k ， map.get(sum-k) == 1， 是一个解
        map.put(0,1);
        
        int sum = 0, res  = 0;
        for(int i = 0; i < nums.length ;i++){
            sum += nums[i];
            
            if(map.containsKey(sum - k))
                res += map.get(sum-k);   // sum1+sum2 = k ，说明sum2-sum1那一段是一个解
            map.put(sum, map.getOrDefault(sum,0)+1);
            System.out.println(sum + "  " + map.get(sum));
        }
        return res;
    }
    
    
    
    
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hs = new HashMap();
        hs.put(0,1);
        int res = 0;
        for (int sum = 0, i = 0; i < nums.length ; i++) {
            sum += nums[i];
            res += hs.getOrDefault(sum-k,0);    // sum1+sum2 = k ，说明sum2-sum1那一段是一个解
            hs.put(sum, hs.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
