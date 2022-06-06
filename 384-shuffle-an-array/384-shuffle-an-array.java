class Solution {
    
    int[] arr ;
    int[] curr;
    Random rnd;

    public Solution(int[] nums) {
        arr = nums;
        curr = arr.clone();
        rnd = new Random();
    }
    
    public int[] reset() {
        curr = arr.clone();
        return arr;
    }
    
    public int[] shuffle() {
        rnd = new Random();
        int[] ans = curr.clone();
        int len = curr.length;
        int times = len;
        while(times>0){
            int pos =  rnd.nextInt(times);
            swap(ans, pos, times-1);
            times--;
        }
        return ans;
        
    }
    
    private void swap(int[] arr , int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */