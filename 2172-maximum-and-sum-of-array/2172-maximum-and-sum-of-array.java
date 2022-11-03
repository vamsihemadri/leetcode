class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        
        int n = nums.length;
        int[] arr = new int[2*numSlots];
        for(int i = 0;i<n;i++){
            arr[i] = nums[i];
        }
        
        
        int N = arr.length;
        Integer[] dp = new Integer[1<<N];
        return recur(dp,arr, (1<<N) - 1);
    }
    
    private int recur(Integer[] dp, int[] arr, int state){
        if(state==0)
            return 0;
        if(dp[state]!=null)
            return dp[state];
        
        int ans = 0;
        for(int i = 0;i<arr.length;i++){
            
            int count = getSetBitsCount(state);
            int slot = (count+1)/2;
            
            if((state & (1<<i))!=0){
                ans = Math.max(ans, (arr[i]&slot)+recur(dp, arr, state - (1<<i)));
            }
        }
        
        dp[state] = ans;
        return ans;
        
    }
    
    
    private int getSetBitsCount(int num){
        int count = 0;
        while(num>0){
            count++;
            num &= num-1;
        }
        return count;
    }
}