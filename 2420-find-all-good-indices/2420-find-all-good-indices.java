class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        
        int len = nums.length;
        
        int[] pre = new int[len];
        int[] suf = new int[len];
        
        pre[0] = 1;
        for(int i = 1;i<len;i++){
            if(nums[i]>nums[i-1]){
                pre[i] = 1;
                continue;
            }
            pre[i] = pre[i-1]+1;
        }
        
        suf[len-1] = 1;
        
        for(int i = len-2;i>=0;i--){
            if(nums[i]>nums[i+1]){
                suf[i] = 1;
                continue;
            }
            suf[i] = suf[i+1]+1;
        }
        
        List<Integer> ans = new ArrayList();
        
        for(int i = 1;i<len-1;i++){
            if(pre[i-1]>=k && suf[i+1]>=k)
                ans.add(i);
        }
        return ans;
    }
}