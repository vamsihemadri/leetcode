class Solution {
    public boolean checkPossibility(int[] nums) {
        
        
        int pos =1;
        
        int max = Integer.MIN_VALUE;
        
        while(pos<nums.length){
            max = Math.max(max, nums[pos-1]);
            if(nums[pos]<nums[pos-1]){
                break;
            }
            pos++;
        }
        
        if(pos==nums.length)
            return true;
        
        int ipos = pos;
        int count = 0;
        int min  = Integer.MAX_VALUE;
        while(pos<nums.length){
            min = Math.min(min, nums[pos]);
            
            if(pos<nums.length-1){
                if(nums[pos]>nums[pos+1])
                    return false;
            }
            if(nums[pos]<max){
                count++;
            }
            pos++;
        }
        
        
        if(count<2)
            return true;
        if(ipos==1)
            return true;
        
        count = 0;
        int i = 0;
        while(i<=ipos){
            if(nums[i]>min){
                count++;
            }
            i++;
        }
        if(count<2)
            return true;
        return false;
    }
}