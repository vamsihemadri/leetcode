class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        Set<Integer> state = new HashSet();
        
        int max = 0;
        int left = 0;
        int curr = 0;
        
        for(int right = 0;right<nums.length;right++){
            
            if(!state.contains(nums[right])){
                curr+=nums[right];
                state.add(nums[right]);
            }else{
                
                while(left<right && nums[left]!=nums[right]){
                    curr-=nums[left];
                    state.remove(nums[left++]);
                }
                if(left!=right && nums[left]==nums[right])
                    left++;
                
            }
            
            max = Math.max(max, curr);
            
        }
        return max;
    }
}