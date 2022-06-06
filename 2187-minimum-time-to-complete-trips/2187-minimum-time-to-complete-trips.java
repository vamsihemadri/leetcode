class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        
        Arrays.sort(time);
        Long low = 0l;
        Long high  = Long.MAX_VALUE;
        
        Long ans= 0l;
        
        while(low+1<high){
            Long mid = low + (high-low)/2;
            
            Long numTrips = 0l;
        
            for(int t: time){
                numTrips+=mid/t;
                if(numTrips<0)
                    break;
            }
            
            if(numTrips<0){
                high = mid;
                continue;
            }
                
            if(numTrips>=totalTrips){
                ans = mid;
                high = mid;
            }else{
                low = mid;
            }
            
        }
        
        return ans;
    }
}