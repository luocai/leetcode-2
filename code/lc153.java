 public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while(left < right){
            int m = left + (right - left) / 2;
            
            if(nums[m] > nums[right]){ // m在较大那一段 , 说明结果在 [m+1, n] 中
                left = m+1;
            }else{   // m 在较小的那一段 ， 说明结果在 [0, m]上
                right = m;
            }
        }
        // 结果一定是left
        return nums[left];
    }
