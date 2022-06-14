class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] dp= new Integer[word1.length()][word2.length()];
        return recur(word1,word2,0,0,dp);
    }
    
    
    private int recur(String s1, String s2, int i, int j, Integer[][] dp){
        
        if(i==s1.length()){
            return s2.length()-j;
        }
        if(j==s2.length()){
            return s1.length()-i;
        }
        
        if(dp[i][j]!=null)
            return dp[i][j];
        
        int one = Integer.MAX_VALUE;
        
        if(s1.charAt(i) == s2.charAt(j)){
            one = recur(s1,s2,i+1,j+1,dp);
        }
        int two = 1+recur(s1,s2,i+1,j,dp);
        int three = 1+recur(s1,s2,i,j+1,dp);
        
        int ans = Math.min(one,Math.min(two, three));
        dp[i][j] = ans;
        return ans;
    }
}