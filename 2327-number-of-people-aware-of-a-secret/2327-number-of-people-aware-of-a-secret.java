class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n+1];
        dp[1] = 1;
        long share = 0l;
        int mod = 1000000007;
        for(int i = 2;i<=n;i++){
            share +=(dp[Math.max(0,i-delay)])%mod;
            share -=dp[Math.max(0,i-forget)];
            share+=mod;
            share %=mod;
            dp[i] = share;
            
        }
        
        long ans = 0;
        for(int i = n-forget+1;i<=n;i++){
            ans+=dp[i];
            ans%=mod;
        }
        return (int)ans;
    }
}