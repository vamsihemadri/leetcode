class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        
        if(len<2)
            return len;
        
        int[] up = new int[len];
        int[] down = new int[len];
        
        for(int i = 1;i<len;i++){
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    up[i] = Math.max(up[i],1+down[j]);
                }else if(nums[i]<nums[j]){
                    down[i] = Math.max(up[j]+1,down[i]);
                }
            }
        }
        
        return 1+Math.max(up[len-1],down[len-1]);
    }
}