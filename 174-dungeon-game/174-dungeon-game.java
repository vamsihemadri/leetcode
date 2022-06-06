class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int[][] dp = new int[m][n];
        
        if(dungeon[m-1][n-1]>=0){
            dp[m-1][n-1] = 1;
        }else{
            dp[m-1][n-1] = 1+Math.abs(dungeon[m-1][n-1]);
        }
        
        
        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                if(i == m-1 && j == n-1){
                    continue;
                    
                }
                int curr = dungeon[i][j];
                
                if(i==m-1){
                    dp[i][j] = Math.max(1,dp[i][j+1]-curr);
                    continue;
                }
                if(j==n-1){
                    dp[i][j] = Math.max(1,dp[i+1][j]-curr);
                    continue;
                }
                
                dp[i][j] = Math.max(1, Math.min(dp[i+1][j]-curr, dp[i][j+1]-curr));
                
            }
        }
        return dp[0][0];
    }
}