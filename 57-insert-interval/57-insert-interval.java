class Solution {
    public int[][] insert(int[][] intervals, int[] ni) {
        int l = intervals.length;
        if(l==0){
            int[][] an = new int[1][2];
            an[0] = ni;
            return an;
        }
        int pos = getPosition(intervals, ni);
        // insert at pos +1;
        //merge from pos; 
        List<int[]> ans = new ArrayList();
        for(int i = 0;i<pos;i++){
            ans.add(intervals[i]);
        }
        int[] curr = new int[2];
        // combine pos and ni 
        if(ni[0] > intervals[pos][1]){
            ans.add(intervals[pos]);
            curr= ni;
            pos++;
        }else if(ni[1] < intervals[pos][0]){
            ans.add(ni);
            curr= intervals[pos];
        }
        else{
            curr[0] = Math.min(intervals[pos][0], ni[0]);
            curr[1] = Math.max(intervals[pos][1], ni[1]);
            pos++;
        }
        while(pos<intervals.length){
            if(intervals[pos][0] <= curr[1]){
                curr[0] = Math.min(curr[0], intervals[pos][0]);
                curr[1] = Math.max(curr[1], intervals[pos][1]);
            }else{
                ans.add(curr);
                curr = intervals[pos];
            }
            pos++;
        }
        ans.add(curr);
        
        return ans.toArray(new int[ans.size()][]);
    }
    
    private int getPosition(int[][] intervals, int[] interval){
        int low = -1;
        int high = intervals.length-1;
        int mid;
        while(low+1<high){
            mid = low + (high-low)/2;
            if(intervals[mid][1]>=interval[0]){
                high = mid;
            }else{
                low = mid;
            }
        
    }
        return high;
}
}