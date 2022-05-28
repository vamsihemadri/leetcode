class Solution {
    public int missingNumber(int[] nums) {
        
        int n = nums.length;
        int j = 0;
        while(j<n){
            int pos = nums[j];
            if(pos<n && pos!=j){
                swap(nums,j,pos);
            }else{
                j++;
            }
        }
        
        for(int i=0;i<n;i++){
            if(nums[i]!=i){
                return i;
            }
        }
        return n;
    }
    private void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}