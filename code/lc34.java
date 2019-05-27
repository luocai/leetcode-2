package code;
/*
 * 31. Find First and Last Position of Element in Sorted Array
 * 题意：在有序数组中寻找某个数的起始和终止位置
 * 难度：Medium
 * 分类：Array, Binary Search
 * 思路：两次二分查找，第一次找到起始位置，第二次找终止位置
 * Tips：注意/2时是否+1
 */
public class lc34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] res = searchRange(nums,8);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

     //思路，用二分 分别 找第一和最后出现的
    public int[] searchRange(int[] nums, int target) {
        
        int[] res = new int[2];
        
        res[0] = serachF(nums, target);
        res[1] = serachE(nums,target);
        
        return res;
    }
    
    // 先用二分找第一个出现的，注意 判断条件（一个等号的差别）
    // 找第一个，  >=  return  l
    public int serachF(int[] nums,int target){
        
        int i = 0, j  = nums.length-1;
        
        while(i <= j){
            
            int m = (i +j ) / 2;
            
            if(nums[m] >= target){
                j = m-1;
            }else {
                i = m+1;
            }
        }
        if(i < nums.length && nums[i] == target)
            return i;
        else 
            return -1;
        
    }
    
     // 再用二分找最后一个出现的，注意 判断条件（一个等号的差别）
   // 找最后一个，  <=  return  r
    public int serachE(int[] nums, int target){
        
        int i = 0, j  = nums.length-1;
        
        while(i <= j){
            
            int m = (i +j ) / 2;
            
            if(nums[m] > target){
                j = m-1;
            }else {
                i = m+1;
            }
        }
        if(j >= 0 && nums[j] == target)
            return j;
        else
            return -1;

    }
    
    
    //法二：先用二分找出位置，在向两边延伸
     public int[] searchRange(int[] nums, int target){
		
		//int flag = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == target){
			//	flag = 1;
				int j = i;
				while(j <= nums.length-2 && nums[j+1] == target){
					j++;
				}
				return new int[]{i, j};
			}
		}
		return new int[] {-1,-1};
		
	}
    
}
