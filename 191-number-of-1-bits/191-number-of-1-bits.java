public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if(n==0)
            return 0;
        
        // n &n-1 sets the right most bit to 0.
        return hammingWeight(n&(n-1)) +1;
    }
}