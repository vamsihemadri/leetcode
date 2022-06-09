class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        Map<Integer, Set<Integer>> stopToRoutesMap = new HashMap();
        
        int i = 0;
        for(int[] route: routes){
            for(int stop : route){
                Set<Integer> r = stopToRoutesMap.getOrDefault(stop, new HashSet());
                r.add(i);
                stopToRoutesMap.put(stop, r);
            }
            i++;
        }
        
        Set<Integer> visited = new HashSet();
        boolean[] seenRoutes = new boolean[i];
        
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{source, 0});
        
        visited.add(source);
        
        
        while(!q.isEmpty()){
            int[] top = q.poll();
            if(top[0]==target)
                return top[1];
            
            
            Set<Integer> routesOfStop = stopToRoutesMap.getOrDefault(top[0],new HashSet());
            for(int r : routesOfStop){
                if(!seenRoutes[r]){
                    int[] stops = routes[r];
                    for(int stop :  stops){
                        if(!visited.contains(stop)){
                            visited.add(stop);
                            q.offer(new int[]{stop, top[1]+1});
                        }
                    }
                    seenRoutes[r] = true;
                }
            }
        }
        return -1;
        
    }
}