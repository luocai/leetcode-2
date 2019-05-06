package code;
/*
 * 287. Find the Duplicate Number
 * 题意：n+1个数属于[1~n]，找出重复的那个数
 * 难度：Medium
 * 分类：Array, Two Pointers, Binary Searn+1个数属于[1~n]，找出重复的那个数ch
 * 思路：如果nums[i]不在对应位置，则和对应位置交换。如果对应位置上也为该数，说明这个数就是重复的数字。这个方法改变了数组。是错误的。
 *      另一种方法，把问题转换成有环链表，找环的起始节点。O(n) O(1) lc142
 *      二分查找，每次看一边数字的个数, O(nlog(n)) O(1)
 * Tips：剑指offer原题
 *       lc268 lc448 lc287
 */
public class lc287 {
    
     //使用数组配合下标，抽象成链表问题
    //nums = [2,5, 9 ,6,9,3,8, 9 ,7,1]，构造成链表就是：2->[9]->1->5->3->6->8->7->[9]，也就是在[9]处循环。
    public static int findDuplicate(int[] nums) {
	      
        int slow = nums[0];
        int fast = nums[nums[0]];
        
        // 因为有环，必然相遇，会在环内的任何一个节点相遇
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        // 寻找环入口
        fast = 0;  
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
		  
	 }
    
    // 归位大法，是错误的，与题意不符合
    public static int findDuplicate(int[] nums) {
	        
		  //每次遍历归位一个元素  1 2 3
	        for(int i = 0; i < nums.length ;){
	        	
	        	//记住，只有昂该位归位， i才要+
	            if(nums[i] == i+1){
	            	i++;
	            	continue;
	            }
	            
	            // 需要归位的位置
	            int index = nums[i]-1;
	            
	            //判断该位置是否已经归位，因为nums[i] 要换过去， 如果目标位置有了，就重复
	            if(nums[index] == nums[i]){
	                return nums[index];
	            }
	            //如果未归位， 则交换这两个位置
	            int temp = nums[index];
	            nums[index] = nums[i];
	            nums[i] = temp;
	            
	        }
	        return -1;
	 }
    
    
    public int findDuplicate(int[] nums) {  //该方法修改了数组，是错误的，没看清题意
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i]!=i+1){
                int temp = nums[nums[i]-1];
                if(temp==nums[i])
                    return temp;
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
                i--;
            }
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;   // fast是0,不是nums[0]
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
