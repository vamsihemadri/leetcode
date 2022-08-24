class Solution {
    public boolean isPowerOfThree(int n) {
        
        if(n==0)
            return false;
        if(n<0)
            return false;
        while(abs(n)!=1){
            if(n%3!=0)
                return false;
            n/=3;
        }
        return true;
    }
    
    private int abs(int x){
        if(x>0)
            return x;
        return -x;
    }
}
