class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, List<String>>adjMap = new HashMap();
        
        for(List<String> list: tickets){
            adjMap.computeIfAbsent(list.get(0),k->new ArrayList());
            adjMap.get(list.get(0)).add(list.get(1));
        }
        
        List<String> ans = new ArrayList();
        for(Map.Entry<String, List<String>> entry: adjMap.entrySet()){
            Collections.sort(entry.getValue());
        }
        
        recur(adjMap, ans, "JFK");
        Collections.reverse(ans);
        return ans;
        
    }
    
    private void recur(Map<String, List<String>> adjMap, List<String> ans, String curr){
        
        List<String> neis = adjMap.getOrDefault(curr, new ArrayList());
        while(neis.size()>0){
            String nei=neis.get(0);
            neis.remove(0);
            recur(adjMap,ans,nei);
        }
        
        ans.add(curr);
    }
}