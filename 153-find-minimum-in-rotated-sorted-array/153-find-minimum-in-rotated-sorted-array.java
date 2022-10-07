class Solution {
    public int findMin(int[] nums) {
        
        int r = getRotate(nums);
        if(r==nums.length-1)
            return nums[0];
        if(nums.length==1)
            return nums[0];
        if(nums[r]<nums[r+1])
            return nums[r];
        return nums[r+1];
    }
    
    private int getRotate(int[] nums){
                
        int low =-1;
        int high = nums.length-1;
        
        while(low+1<high){
            int mid = low + (high-low)/2;
            
            if(nums[mid]>nums[mid+1])
                return mid;
            
            if(nums[high]>nums[mid])
                high = mid;
            else
                low = mid;
            
        }
        
        return high;
    }
}