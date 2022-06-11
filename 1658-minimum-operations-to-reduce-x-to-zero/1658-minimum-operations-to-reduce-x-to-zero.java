class Solution {
    public int minOperations(int[] nums, int x) {
        
        long sum = 0;
        int len = nums.length;
        
        Map<Long, Integer> sumMap = new HashMap();
        int longest = -1;
        
        long total = 0l;
        for(int n : nums){
            total+=n;
        }
        
        long X = total-x;
        sumMap.put(0l,-1);
        
        for(int i = 0;i<len;i++){
            sum+=nums[i];
            
            if(sumMap.containsKey(sum-X)){
                longest = Math.max(longest, i-sumMap.get(sum-X));
            }
            
            if(!sumMap.containsKey(sum)){
                sumMap.put(sum,i);
            }
        }
        if(sumMap.containsKey(sum-X))
            longest = Math.max(longest, len-1-sumMap.get(sum-X));
        
        if(longest==-1)
            return -1;
        
        return len-longest;
    }
}