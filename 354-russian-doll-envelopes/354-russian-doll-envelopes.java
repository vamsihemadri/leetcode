class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes, new CustomComparator());
        int[] arr = new int[envelopes.length];
        for(int i = 0;i<arr.length;i++)
            arr[i] = envelopes[i][1];
        
        return LIS(arr);
    }
    
    private int LIS(int[] arr){
        ArrayList<Integer> ans = new ArrayList();
        
        for(int i = 0;i<arr.length;i++){
            if(ans.isEmpty() || arr[i]>ans.get(ans.size()-1)){
                ans.add(arr[i]);
                continue;
            }
            int  j = binarySearch(ans, arr[i]);
            ans.set(j, arr[i]);
        }
        
        return ans.size();
    }
    
    
        
    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = -1;
        int right = sub.size() - 1;
        while(left+1<right){
            int mid = left + (right-left)/2;
            // if(sub.get(mid)==num)
            //     return mid;
            if(sub.get(mid)>=num)
                right = mid;
            else
                left = mid;
        }
        
        return right;
    }
    
}

class CustomComparator implements Comparator<int[]>{
    public int compare(int[] a , int[] b){
        if(a[0]!=b[0]){
            return a[0]-b[0];
            
        }
        return b[1]-a[1];
    }
}