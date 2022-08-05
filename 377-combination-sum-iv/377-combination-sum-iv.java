class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        Integer[] mem = new Integer[1001];
        return recur(nums, target, mem);
    }
    
    private int recur(int[] nums, int target, Integer[] mem){
        if(target<0)
            return 0;
        if(target==0){
            return 1;
        }
        if(mem[target]!=null){
            return mem[target];
        }
        int count = 0;
        for(int n : nums){
             count+=recur(nums, target-n, mem);
        }
        mem[target]= count;
        return count;
    }
}