class RLEIterator {

    int pos;
    int[] arr;
    public RLEIterator(int[] encoding) {
        arr = encoding;
        pos = 0;
    }
    
    public int next(int n) {
        
        int ans = -1;
        while(pos<arr.length){
            if(n<arr[pos]){
                ans = arr[pos+1];
                arr[pos] -=n;
                break;
            }else if(n==arr[pos]){
                ans = arr[pos+1];
                pos+=2;
                break;
            }else{
                n-=arr[pos];
                pos+=2;
            }
        }
        return ans;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */