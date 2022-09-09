class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        Arrays.sort(properties,(a,b)->(a[0]==b[0])?b[1]-a[1]:a[0]-b[0]);
        
        int ans = 0;
        int maxSoFar = Integer.MIN_VALUE;
        for(int i = properties.length-1;i>=0;i--){
            
            if(properties[i][1]<maxSoFar){
                ans++;
            }
            
            maxSoFar = Math.max(maxSoFar, properties[i][1]);
        }
        return ans;
    }
}