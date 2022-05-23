class Solution {
    
    private int[] countOnesAndZeros(String str){
        int ones = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)=='1')
                ones++;
        }
        return new int[]{ones, str.length()-ones};
    }
    
    // return the max size of subset from index with m ones and n zeros.
    private Integer recur(Integer[][][] dp, int index, int m, int n,String[] strs){
        
        if(index==strs.length)
            return 0;
        if(dp[index][m][n]!=null)
            return dp[index][m][n];
        int[] onesAndZerosCount = countOnesAndZeros(strs[index]);
        int taken = -1;
        int ones = m-onesAndZerosCount[0];
        int zeros = n-onesAndZerosCount[1];
        
        if(ones>=0 && zeros>=0){
            taken = 1+recur(dp, index+1, ones, zeros, strs);
        }
        int notTaken = recur(dp, index+1, m,n,strs);
        dp[index][m][n] = Math.max(taken, notTaken);
        return dp[index][m][n];
    }
    
    public int findMaxForm(String[] strs, int m, int n) {
        Integer[][][] dp = new Integer[strs.length][n+1][m+1];
        return recur(dp, 0,n,m, strs);
    }
}