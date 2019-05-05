package code;
/*
 * 215. Kth Largest Element in an Array
 * 题意：找第k大的数
 * 难度：Medium
 * 分类：Divide and Conquer, Heap
 * 思路：快排的思想
 * Tips：经典的题目，记一下代码格式，方便快速写出
 */
public class lc215 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }
    public int findKthLargest(int[] nums, int k) {
        return partion(nums, 0, nums.length-1, k);
    }
    
    //快排
    public int partion(int[] nums, int s, int e, int k){
        
     
        int i = s, j = e;
        int x = nums[i];

        while(i < j){
            // 注意和普通快排的区别， 此处是逆序  顺序是 nums[j] >= x
            while(j > i && nums[j] <= x)
                j--;
            nums[i] = nums[j];
            while(j > i && nums[i] >= x)
                i++;
            nums[j] = nums[i];

        }
        nums[i] = x;

        if(i == k-1)
            return x;
        else if(i > k-1)
            return partion(nums, s,i-1,k);
        else 
            return partion(nums, i+1, e, k);

    }
    
    //堆排序
     public int findKthLargest(int[] nums, int k) {
        for(int i = nums.length / 2 - 1; i >= 0; i--){
            heapAdjust(nums, i, nums.length);
        }
        
        for(int i = nums.length-1; i >= nums.length -k; i--){
            swap(nums, i, 0);
            heapAdjust(nums, 0, i);
        }
        
        return nums[nums.length - k];
    }
    
    public void heapAdjust(int[] arr, int index ,int len){
        int temp = arr[index];
        for(int i = 2*index+1; i < len; i=2*i+1){
            if(i+1 < len && arr[i] < arr[i+1]){
                i++;
            }
            if(arr[i] > temp){
                arr[index] = arr[i];
                index = i;
            }else{
                break;
            }
        }
        arr[index] = temp;
    }
    
    public void swap(int[] arr ,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
