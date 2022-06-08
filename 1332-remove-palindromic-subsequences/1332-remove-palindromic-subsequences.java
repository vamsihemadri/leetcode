class Solution {
    public int removePalindromeSub(String s) {
        
        if(isPalindrome(s))
            return 1;
        return 2;
    }
    
    private boolean isPalindrome(String s){
        int low = 0;
        int high = s.length()-1;
        
        while(low<high){
            if(s.charAt(low)==s.charAt(high)){
                low++;
                high--;
                continue;
            }
            return false;
        }
        return true;
    }
}