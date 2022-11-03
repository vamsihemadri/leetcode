class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        
        List<Set<Integer>> adjList = new ArrayList();
        
        IntStream.range(0,n).forEach(i->adjList.add(new HashSet()));
        
        for(int[] road: roads){
            int s = road[0];
            int d = road[1];
            
            adjList.get(s).add(d);
            adjList.get(d).add(s);
        }
        
        int max = -1;
        int smax = -1;
        
        int ans = -1;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int temp = adjList.get(i).size() + adjList.get(j).size();
                
                if(adjList.get(i).contains(j))
                    temp--;
                
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }
}