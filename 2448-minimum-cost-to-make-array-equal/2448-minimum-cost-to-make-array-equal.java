class Solution {
    public long minCost(int[] nums, int[] cost) {
        
        int low = 1;
        int high = 1000001;
        
        long ans = getCost(nums, cost, low);
        
        while(low+1<high){
            int mid = low + (high-low)/2;
            long midCost = getCost(nums, cost, mid);
            long nextCost = getCost(nums, cost, mid+1);
            
            ans =Math.min(midCost, nextCost);
            
            if(midCost<nextCost){
                high = mid;
            }else{
                low = mid;
            }
        }
        //ans = Math.min(ans,getCost(nums, cost, low));
        //ans =Math.min(ans, getCost(nums, cost,low+1));
        return ans;
    }
    
    private long getCost(int[] nums, int[] cost, int x){
        long ans = 0l;
        int i = 0;
        for(int n:nums){
            ans+= 1l*cost[i] * (Math.abs(n-x));
            i++;
        }
        return ans;
    }
}