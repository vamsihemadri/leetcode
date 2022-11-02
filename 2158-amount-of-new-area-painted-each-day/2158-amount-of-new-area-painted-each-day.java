class Solution {
    public int[] amountPainted(int[][] paint) {
        
        
        TreeSet<int[]> set = new TreeSet<>((a,b)->Integer.compare(a[1],b[1]));
        
        int[] ans = new int[paint.length];
        
        for(int i = 0;i<paint.length;i++){
            int s = paint[i][0];
            int e = paint[i][1];
            
            int covered = 0;
            
            Iterator<int[]> it = set.tailSet(new int[]{0,s}).iterator();
            
            while(it.hasNext()){
                int[] arr = it.next();
                
                if(arr[0]>e)
                    break;
                
                covered+=arr[1]-arr[0];
                s=Math.min(s,arr[0]);
                e=Math.max(e,arr[1]);
                
                it.remove();
                
            }
            
            set.add(new int[]{s,e});
            
            ans[i] = e-s-covered;
        }
        
        
        return ans;
        
    }
}