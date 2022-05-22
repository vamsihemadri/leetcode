class Solution {
    
    int count = 0;
    Boolean[][] dp;
    public int countSubstrings(String s) {
        int len = s.length();
        
        dp = new Boolean[len][len];
        
        //isPalindrome(0,len-1,s);
        
        for(int i = 0;i<len;i++){
            for(int j = 0;j<len;j++){
                isPalindrome(i,j,s);
                if(dp[i][j]!=null && dp[i][j]==true){
                    count++;
                    System.out.println(i + "#"+ j);
                }
            }
        }
        return count;
    }
    
    
    private Boolean isPalindrome(int i, int j, String s){
        
        if(i==j){
            dp[i][j] = true;
            return true;
        }
        if(j-i+1==2 && s.charAt(i)==s.charAt(j)){
            dp[i][j] = true;
            return true;
            
        }
        if(i>j){
            dp[i][j] = false;
            return false;
        }
        
        if(dp[i][j]!=null)
            return true;
        
        boolean ans = false;
        if(s.charAt(i) == s.charAt(j)){
            ans = isPalindrome(i+1,j-1,s);
        }
        
        dp[i][j] = ans;
        return ans;
        
    }
}
