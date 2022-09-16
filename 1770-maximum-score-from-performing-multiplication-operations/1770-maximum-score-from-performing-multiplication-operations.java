class Solution {
    int[] nums;
    int[] mult;
    Integer[][] dp;
    int n,m;
    
    public int maximumScore(int[] nums, int[] mult) {
        this.n = nums.length;
        this.m = mult.length;
        
        this.nums = nums;
        this.mult = mult;
        
        Integer[][] dp = new Integer[m][m];
        this.dp = dp;
        
        foo( 0, 0);
        
//         for(int i = m-1;i>=0;i--){
            
//         }
        
        return dp[0][0];
    }
    
    
    
    private int foo( int pos, int left){
        if(pos>=m)
            return 0;
        
        if(dp[pos][left]!=null)
            return dp[pos][left];
        
        int right = n-pos+left-1;
        int o1 = mult[pos] *nums[left] + foo(pos+1, left+1);
        int o2 = mult[pos] *nums[right] + foo(pos+1, left);
        
        dp[pos][left] = Math.max(o1,o2);
        return dp[pos][left];
        
    }
}