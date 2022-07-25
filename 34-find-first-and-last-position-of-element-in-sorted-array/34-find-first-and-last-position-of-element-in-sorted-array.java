class Solution {
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if(length == 0){
            return new int[]{-1,-1};
        }

        
        int[] ans = new int[2];
        
        int low = 0;
        int high = length;
        
        while(low+1<high){
            int mid = low + (high-low)/2;
            
            if(nums[mid]<=target){
                low = mid;
            }else{
                high = mid;
            }
        }

        if(low==0 && nums[low]==target){
            return ans;
        }
        if(nums[low]==target){
            ans[1] = low;
        }else{
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        
        low = -1;
        high = length-1;
        
        while(low+1<high){
            int mid = low + (high-low)/2;
            
            if(nums[mid]>=target){
                high = mid;
            }else
                low= mid;
        }
        
        ans[0] = high;
        
        return ans;
        
    }
}