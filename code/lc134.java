package code;
/*
 * 134. Gas Station
 * 题意：给两个数组，一个表示在该点能加多少油，一个表示该点到下个点消耗多少油，加油站连成一个环，问能否走遍所有加油站，从哪一站开始
 * 难度：Medium
 * 分类：Greedy
 * 思路：计算两个数组的差，再把每个位置加起来，如果>=0，则能跑完。位置为最大连续子数组的开始位置。
 * Tips：lc53
 */
public class lc134 {
    // 思路很巧妙
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int start = 0, total = 0, sum = 0;
        
        for(int i = 0; i < gas.length ;i++){
            total += (gas[i] - cost[i]);
            sum += ( gas[i] - cost[i]);
            if(sum < 0){
                sum = 0;
                // i+1 ， 因为i 不能满足
                start = i + 1;
            }
        }
        
        // 如果加油总量小于消耗总量，比如走不完，否则可以
        if(total < 0)
            return -1;
        else
            return start;
    }
    
    ---------------------
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] arr = new int[gas.length];
        int sum = 0, pos = 0, dp =0;
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = gas[i] - cost[i];
            sum += arr[i];

            if(dp<=0) { //最大连续子数组，并记录位置
                dp = arr[i];
                pos = i;
            }
            else
                dp += arr[i];
        }
        return sum<0? -1: pos;
    }
}
