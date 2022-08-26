class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] nCount = getCount(n);
        for(int i = 0;i<31;i++){
            if(Arrays.equals(nCount, getCount(1<<i)))
                return true;
        }
        return false;
    }
    
    private int[] getCount(int N){
        int[] ans = new int[10];
        while(N>0){
            ans[N%10]++;
            N/=10;
        }
        return ans;
    }
}