class Solution {
    public int countVowelPermutation(int n) {
        long ans = 0;
        
        Long[][] dp = new Long[n][5];
        int mod = 1000000007;
        
        ans+=recur(0,0,n,dp,mod)%mod;
        ans%=mod;
        
        ans+=recur(0,1,n,dp,mod)%mod;
        ans%=mod;
        
        ans+=recur(0,2,n,dp,mod)%mod;
        ans%=mod;
        
        ans+=recur(0,3,n,dp,mod)%mod;
        ans%=mod;
        
        ans+=recur(0,4,n,dp,mod)%mod;
        ans%=mod;
        
        return (int)(ans);
    }
    
    private long recur(int pos,int ch, int n, Long[][] dp, int mod){
        if(pos==n)
            return 0;
        if(pos==n-1)
            return 1;
        if(dp[pos][ch]!=null)
            return dp[pos][ch];
        
        long temp = 0;
        if(ch==0){
            temp = recur(pos+1,1,n,dp,mod)%mod;
        }
        if(ch==1){
            temp = recur(pos+1,0,n,dp,mod)%mod;
            temp+=recur(pos+1, 2,n,dp,mod)%mod;
            temp%=mod;
        }
        if(ch==2){
            temp+=recur(pos+1, 0,n,dp,mod)%mod;
            temp%=mod;
            
            temp+=recur(pos+1, 1,n,dp,mod)%mod;
            temp%=mod;
            
            temp+=recur(pos+1, 3,n,dp,mod)%mod;
            temp%=mod;
            
            temp+=recur(pos+1, 4,n,dp,mod)%mod;
            temp%=mod;
        }
        if(ch==3){
            temp+=recur(pos+1, 2,n,dp,mod)%mod;
            temp%=mod;
            
            temp+=recur(pos+1, 4,n,dp,mod)%mod;
            temp%=mod;
        }
        if(ch==4){
            temp+=recur(pos+1, 0,n,dp,mod)%mod;
            temp%=mod;
        }
        dp[pos][ch] = temp;
        return temp;
    }
}