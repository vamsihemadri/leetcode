class Solution {
    public int[] findMaximums(int[] nums) {
        
        
        int len = nums.length;
        
        int[] ans = new int[len];
        Arrays.fill(ans, Integer.MIN_VALUE);
        
        int[] L = new int[len];
        int[] R = new int[len];
        
        ArrayDeque<Integer> deq = new ArrayDeque();
        
        for(int i = 0;i<len;i++){
            while(!deq.isEmpty() && nums[deq.getLast()]>=nums[i]){
                deq.removeLast();
                
            }
            if(deq.isEmpty()){
                L[i] = -1;
            }else{
                L[i] = deq.getLast();
            }
            deq.offerLast(i);
        }
        
        
        deq.clear();
        
        for(int i = len-1;i>=0 ;i--){
            while(!deq.isEmpty() && nums[deq.getLast()]>=nums[i]){
                deq.removeLast();
            }
            if(deq.isEmpty()){
                R[i] = len;
            }else{
                R[i] = deq.getLast();
            }
            deq.offerLast(i);
        }
        
        
        
        for(int i = 0;i<len;i++){
            int window = R[i]-L[i]-1;
            
            ans[window-1] = Math.max(ans[window-1],nums[i]);
        }
        
        for(int i = len-2;i>=0;i--){
            ans[i] = Math.max(ans[i], ans[i+1]);
        }
        return ans;
        
    }
}