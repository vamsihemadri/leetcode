class NumArray {
    
    int[] seg;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        seg = new int[4*n];
        buildTree(nums, 0, n-1, 0);
    }
    
    private void buildTree(int[] arr, int l, int h, int idx){
        if(l==h){
            seg[idx] = arr[l];
            return;
        }
        int mid = l + (h-l)/2;
        buildTree(arr, l, mid, 2*idx+1);
        buildTree(arr, mid+1, h, 2*idx+2);
        seg[idx] = seg[2*idx+1] + seg[2*idx+2];
    }
    
    public void update(int index, int val) {
        updateUtil(index, val, 0 ,n-1, 0);
        
    }
    
    private void updateUtil(int pos, int val , int low, int high, int idx){
        if(low==high){
            seg[idx] = val;
            return;
        }
        
        int mid = low + (high-low)/2;
        if(pos<=mid)
            updateUtil(pos, val, low, mid, 2*idx+1);
        else 
            updateUtil(pos, val, mid+1,high,  2*idx+2);
        
        seg[idx] = seg[2*idx+1] + seg[2*idx+2];
    }
    
    public int sumRange(int left, int right) {
        return rangeUtil(left, right, 0,n-1,0);
    }
    
    private int rangeUtil(int qlow, int qhigh, int low, int high, int idx){
        if(qlow == low && qhigh==high){
            return seg[idx];
        }
        int mid = low + (high-low)/2;
        if(qhigh<=mid)
            return rangeUtil(qlow, qhigh, low, mid, 2*idx+1);
        else if(qlow>=mid+1)
            return rangeUtil(qlow, qhigh, mid+1, high, 2*idx+2);
        return rangeUtil(qlow, mid, low, mid, 2*idx+1) + rangeUtil(mid+1, qhigh, mid+1, high, 2*idx+2);
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */