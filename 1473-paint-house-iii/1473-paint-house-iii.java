class Solution {
    int inv = Integer.MAX_VALUE;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        
        Integer[][][] dp= new Integer[m][target+1][n+1];
        int ans = recur(dp,0,target,cost,houses, 0,n);
        if(ans==inv)
            return -1;
        return ans;
    }
    
    private int recur(Integer[][][] dp,int pos, int target, int[][] cost, int[] houses, int currColour, int n){
        
        if(pos==houses.length && target==0)
            return 0;
        
        if(pos==houses.length)
            return inv;
        if(target<0)
            return inv;
        
        if(dp[pos][target][currColour]!=null)
            return dp[pos][target][currColour];
        
        
        int ans = inv;
        if(houses[pos]!=0){
            int nextTarget= target;
            if(currColour!=houses[pos])
                nextTarget--;
            int nextCost = recur(dp,pos+1,nextTarget, cost, houses,houses[pos], n);
            if(nextCost!=inv)
                ans = Math.min(ans, nextCost); 
        }
        else {
            for(int colour = 1;colour<=n;colour++){
                int nextTarget = target;
                if(currColour!=colour)
                    nextTarget--;
                houses[pos] = colour;
                int nextCost = recur(dp,pos+1,nextTarget, cost, houses, colour, n);
                if(nextCost!=inv)
                    ans = Math.min(ans, nextCost+cost[pos][colour-1]);
                houses[pos]=0;
            }
        }
        
        dp[pos][target][currColour] = ans;
        return ans;
        
    }
}