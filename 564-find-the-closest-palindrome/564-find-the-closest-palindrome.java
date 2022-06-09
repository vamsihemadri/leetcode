class Solution {
    public String nearestPalindromic(String n) {
        
        

        Long num = Long.parseLong(n);
        if(num<=9)
            return "" + (num-1);
        Long fromSecond = Long.parseLong(n.substring(1));
        if(n.charAt(0)=='1' && fromSecond ==0l){
            return String.valueOf(num-1);
        }

        
        if(num == 11 || (n.charAt(0)=='1' && fromSecond == 1l)){
            return String.valueOf(num-2);
        }
        
        if(isAllNine(n)){
            return ""+(num+2);
        }
        
        boolean isPalindrome = getIsPalindrome(n);
        
        int len = n.length();
        boolean isEvenLen = len%2==0;
        
        String rootString = n.substring(0,len/2 + 1);
        if(isEvenLen){
            rootString = n.substring(0,len/2);
        }
        
        Long root = Long.parseLong(rootString);
        
        Long next = getPalindromeFromRoot(""+(root+1) , isEvenLen);
        Long prev = getPalindromeFromRoot("" + (root-1), isEvenLen);
        
        String closer = "";
        Long closerDiff = 0l;
        if(Math.abs(prev-num) <= Math.abs(num-next)){
            closer = ""+prev;
            closerDiff = Math.abs(prev-num);
        }
        else{
            closer = ""+next;
            closerDiff = Math.abs(num-next);
        }
        
        if(isPalindrome){
            return closer;
        }
        
        
        Long curr = getPalindromeFromRoot(""+root, isEvenLen);
        if(Math.abs(curr-num)<closerDiff){
            return ""+curr;
        }
        if(Math.abs(curr-num)==closerDiff){
            if(Long.parseLong(closer)<num)
                return closer;
            return ""+curr;
        }
        return closer;
    }
    
    private boolean isAllNine(String n){
        int len = n.length();
        int pos = 0;
        while(pos<len){
            if(n.charAt(pos)!='9')
                return false;
            pos++;
        }
        return true;
    }
    
    private Long getPalindromeFromRoot(String root, boolean isEvenLen){
        
        StringBuilder rev = new StringBuilder().append(root).reverse();
        
        if(!isEvenLen){
            rev.deleteCharAt(0);
        }
        
        return Long.parseLong(new StringBuilder().append(root).append(rev).toString());
    }
    
    
    private boolean getIsPalindrome(String n){
        int len = n.length();
        int low = 0;
        int high = len-1;
        
        while(low<high){
            if(n.charAt(low)!=n.charAt(high)){
                return false;
            }
            
            low++;
            high--;
        }
        return true;
    }
}