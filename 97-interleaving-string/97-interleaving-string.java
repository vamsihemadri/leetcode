class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int  k = s3.length();
        int i = s1.length();
        int j = s2.length();
        if(k==0){
            return i==0 && j==0;
        }
        if(k>i+j)
            return false;
        if(i==0)
            return s3.equals(s2);
        if(j==0)
            return s3.equals(s1);
        Boolean[][] dp = new Boolean[i][j];
        can(0,0,0,s1,s2,s3,dp);
        return dp[0][0];
    }
    
    private Boolean can(int k, int i, int j, String s1, String s2, String s3, Boolean[][] dp){
        if(k==s3.length()){
            return i==s1.length() && j==s2.length();
        }
        if(i==s1.length()){
            return s3.substring(k).equals(s2.substring(j));
        }
        if(j==s2.length()){
            return s3.substring(k).equals(s1.substring(i));
        }
        
        
        if(dp[i][j]!=null)
            return dp[i][j];
        
        Boolean ans = false;
        
        if(s3.charAt(k) == s1.charAt(i)){
            ans = ans|| can(k+1,i+1,j,s1,s2,s3,dp);
        }
        if(!ans){
            if(s3.charAt(k)==s2.charAt(j)){
                ans = ans || can(k+1,i,j+1,s1,s2,s3,dp);
            }
        }
        
        dp[i][j] = ans;
        return ans;
        
    }
}