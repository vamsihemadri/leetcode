class Solution {
    public int maxResult(int[] nums, int k) {
        
        int len = nums.length;
        ArrayDeque<Integer> deq =new ArrayDeque();
        long[] dp = new long[len];
        
        
        dp[0] = nums[0];
        deq.offerLast(0);
        
        for(int i = 1;i<len;i++){
            
            // clean q;
            while(!deq.isEmpty() && deq.getFirst()<i-k){
                deq.removeFirst();
            }
            
            
            int top = deq.getFirst();
            dp[i] = dp[top] + nums[i];
            
            // push i.
            while(!deq.isEmpty() && dp[deq.getLast()]<=dp[i]){
                deq.removeLast();
            }
            deq.offerLast(i);
            
        }
        
        return (int) dp[len-1];
        
    }
}