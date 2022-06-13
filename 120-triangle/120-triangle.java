class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Ans ans = new Ans();
        int m = triangle.size();
        Integer[][] dp = new Integer[m][m];
        return recur(triangle, 0,0, dp);
    }
    
    private int recur(List<List<Integer>> grid, int row, int col, Integer[][] dp){
        
        int m = grid.size();
        if(row==m-1)
            return grid.get(row).get(col);
        
        if(dp[row][col]!=null)
            return dp[row][col];
        
        int one = recur(grid, row+1,col, dp);
        int two = recur(grid, row+1, col+1, dp);
        
        dp[row][col] = Math.min(one, two) + grid.get(row).get(col);
        return dp[row][col];
    }
}

class Ans{
    
    public int val;
    public Ans(){
        this.val = Integer.MAX_VALUE;
    }
    
    public String toString(){
        return String.valueOf(this.val);
    }
    
}