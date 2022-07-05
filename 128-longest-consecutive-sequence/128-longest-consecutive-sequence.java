class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length==0)
            return 0;
        Arrays.sort(nums);
        int left = 0;
        int ans = 1;
        for(int right = 1;right<nums.length;right++){
            if(nums[right]-nums[right-1]==1){
                ans = Math.max(ans, right-left+1);
            }else if(nums[right]==nums[right-1]){
                left++;
            }else{
                left=right;
            }
        }
        
        return ans;
    }
}