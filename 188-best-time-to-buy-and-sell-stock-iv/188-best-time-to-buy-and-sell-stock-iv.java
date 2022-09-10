

class Solution {
    Integer[][] dp;
    int l;
    int[] prices;
    int K;
    
    public int maxProfit(int k,int[] prices) {
        int l = prices.length;
        
        this.l = l;
        this.prices= prices;
        

        this.K = k;
        
        this.dp = new Integer[l][k];
        
        int ans = 0;
        for(int i = 0;i<l;i++){
            ans = Math.max(ans,foo(i,0));
        }
        
        return ans;
        
        //return ans;
        // foo(0,0);
        // return dp[0][0];
        
        
    }
    
    
    private int foo(int low, int k){
        
        if(low>=l)
            return 0;
        if(k==K)
            return 0;
        
        if(low>=l){
            dp[low][k] = 0;
            return 0;
        }
        
        if(dp[low][k]!=null){
            return dp[low][k];
        }
        
        int buy;
        int sell;
        int temp=0;
        int ans= 0;
        
            buy = prices[low];
            for(int j = low;j<=l-1;j++){
                sell = prices[j];
                
                if(sell>buy && k<K){
                    
                    temp = sell-buy + foo(j+1, k+1);
                    
                }
                temp = Math.max(temp,foo(j+1,  k));
                
                ans = Math.max(ans, temp);
            }
        
        
        
        dp[low][k] = ans;
        return ans;
        
    }
}