import java.util.Random;
class Solution {
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    private int put(int[] nums, int low, int high, int pivot){
        int index = low;
        int p = nums[pivot];
        swap(nums, pivot, high);
        for(int i = low; i<= high; i++){
            if(nums[i] < p){
                swap(nums, index, i);
                index++;
            }
        }
        swap(nums, index, high);
        return index;
    }
    
    private int order(int[] nums,int low, int high, int k){
        if(low == high)
            return nums[low];
        Random r = new Random();
        int pivot = low + r.nextInt(high-low);
        //pivot = low;
        pivot= put(nums, low, high, pivot);
        if(pivot == k){
            return nums[pivot];
        }
        if(pivot < k){
            return order(nums, pivot+1, high, k);
        }else
            return order(nums, low, pivot-1, k);
        
    }
    
    public int findKthLargest(int[] nums, int k) {
        int  l = nums.length;
        return order(nums,0,l-1,l-k);
    }
}