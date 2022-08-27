class Solution {
    public boolean isPowerOfFour(int n) {
        
        if(n==Integer.MIN_VALUE)
            return false;
        if(n<0)
            return false;
        if(n==0)
            return false;
        
        if(!isPowerOf2(n)){
            return false;
        }
        
        int count = 0;
        while(n!=1){
            count++;
            n=n/2;
        }
        if(count%2==0)
            return true;
        
        return false;
        
        
        
    }
    
    boolean isPowerOf2(int n){
        return (n&(n-1)) == 0;
    }
}