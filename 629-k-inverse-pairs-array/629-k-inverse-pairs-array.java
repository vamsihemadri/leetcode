class Solution {
    Integer[][] dp = new Integer[1001][1001];
    int mod = 1000000007;
    public int kInversePairs(int n, int k) {
        
        if(n==0)
            return 0;
        if(k==0 || k== ((n*(n-1))/2))
            return 1;
        if(dp[n][k]!=null)
            return dp[n][k];
        if(k>(n*(n-1))/2 || k<0)
            return 0;
        int ans = 0;
        
        int val = (kInversePairs(n-1,k) + mod - ((k-n>=0)?kInversePairs(n-1,k-n):0))%mod;
        ans+=(kInversePairs(n,k-1)+val)%mod;
        dp[n][k] = ans;
        return ans;
    }
}