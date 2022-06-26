class Solution {
    public int maxScore(int[] cp, int k) {
        
        int left = 0;
        int right = cp.length-1;

        int len=  cp.length;
        
        long[] P = new long[len+1];
        
        for(int i = 0;i<len;i++){
            P[i+1] = P[i] + cp[i];
        }
        
        if(len==k)
            return (int) P[len];
        
        long min = Long.MAX_VALUE;
        k=len-k;
        
        for(int i = 0;i<=len-k;i++){
            long sum = P[i+k]-P[i];
            if(sum<min)
                min = sum;
        }
        
        return (int) ( P[len]-min);
    }
}