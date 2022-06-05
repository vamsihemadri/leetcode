class Solution {
    public int numBusesToDestination(int[][] routes, int s, int target) {
        
        if(s==target)
            return 0;
        
        Map<Integer, Set<Integer>> map = new HashMap();
        
        Map<Integer, List<Integer>> map2 = new HashMap();
        
        int r = 0;
        for(int[] route: routes){
            map.computeIfAbsent(r,k-> new HashSet());
            for(int v: route){
                map.get(r).add(v);
                map2.computeIfAbsent(v,k-> new ArrayList());
                map2.get(v).add(r);
            }
            r++;  
        }
        
        for(Integer key: map.keySet()){
            Set<Integer> set = map.get(key);
            if(set.contains(s) && set.contains(target))
                return 1;
        }
        
        
        Map<Integer, Set<Integer>> adjMap = new HashMap();
        
        
        for(Integer key: map2.keySet()){
            List<Integer> list = map2.get(key);
            
            for(int i = 0;i<list.size();i++){
                for(int j = i+1;j<list.size();j++){
                    int source = list.get(i);
                    int dest = list.get(j);
                    
                    adjMap.computeIfAbsent(source, k-> new HashSet());
                    adjMap.get(source).add(dest);
                    
                    adjMap.computeIfAbsent(dest,k-> new HashSet());
                    adjMap.get(dest).add(source);
                }
            }
        }
        
        int[] dist = new int[routes.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        Queue<Integer> q = new LinkedList();
        
        for(int rr: map2.get(s)){
            dist[rr] = 1;
            q.offer(rr);
        }
        
        while(!q.isEmpty()){
            int top = q.poll();
            
            Set<Integer> neis  = adjMap.getOrDefault(top, new HashSet());
            // if(map.getOrDefault(top,new HashSet()).contains(target)){
            //     return dist[top];
            // }
            for(int nei: neis){
                int d = dist[nei];
                
                if(dist[top] + 1 < d){
                    q.offer(nei);
                    dist[nei] = dist[top]+1;
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(Integer rrr : map2.getOrDefault(target,new ArrayList<Integer>())){
            ans = Math.min(ans, dist[rrr]);
        }
        if(ans == Integer.MAX_VALUE)
            return -1;
        return ans;
        
    }
}