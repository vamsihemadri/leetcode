class Solution {
    public int minMoves2(int[] nums) {
        
        int low = getMin(nums);
        int high = getMax(nums)+1;
        
        
        while(low+1<high){
            int mid = low + (high-low)/2;
            if(getCost(mid,nums)>getCost(mid+1,nums))
               low = mid;
            else
                high = mid;
               
        }
        return Math.min((int)getCost(low,nums), (int)getCost(low+1, nums));
    }
    
    private long getCost(int num, int[] nums){
        long cost = 0l;
        
        int pos = 0;
        while(pos<nums.length){
            cost+=Math.abs(nums[pos++]-num);
        }
        return cost;
    }
    
    private int getMin(int[] nums){
        int min = nums[0];
        
        int pos = 1;
        while(pos<nums.length){
            if(nums[pos]<min)
                min = nums[pos];
            pos++;
        }
        return min;
    }
        private int getMax(int[] nums){
        int max = nums[0];
        
        int pos = 1;
        while(pos<nums.length){
            if(nums[pos]>max)
                max = nums[pos];
            pos++;
        }
        return max;
    }
}