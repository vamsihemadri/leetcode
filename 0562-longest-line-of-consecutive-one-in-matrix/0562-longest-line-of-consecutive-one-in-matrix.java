class Solution {
    public int longestLine(int[][] mat) {
        
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        int m = mat.length;
        int n = mat[0].length;
        
        Integer[][][] dp = new Integer[m][n][dirs.length];
        
        int ans = -1;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                for(int d = 0;d<dirs.length;d++){
                    int temp = recur(i,j,d,mat,dp,dirs,m,n);
                    ans = Math.max(ans, temp);
                }
            }
        }
        return ans;
    }
    
    private int recur(int i, int j, int d, int[][] mat, Integer[][][] dp, int[][] dirs,int m, int n){
        
        if(mat[i][j]==0)
            return 0;
        
        if(dp[i][j][d]!=null)
            return dp[i][j][d];
        
        int ans = 1;
        
        int newX = i -dirs[d][0];
        int newY = j-dirs[d][1];
        
        if(newX>=0 && newY>=0 && newX<m && newY<n){
            int temp = recur(newX, newY, d, mat, dp, dirs, m,n);
            ans+=temp;
        }
        
        dp[i][j][d] = ans;
        return ans;
    }
}