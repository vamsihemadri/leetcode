class Solution {
    
    Set<String> words = new HashSet();
    
    private int recur(Map<String, Integer> map, String curr){
        if(map.containsKey(curr))
            return map.get(curr);
        
        StringBuilder sb = new StringBuilder(curr);
        int ans = 1;
        for(int i = 0;i<curr.length();i++){
            sb.deleteCharAt(i);
            if(words.contains(sb.toString())){
                int next = recur(map, sb.toString());
                ans = Math.max(ans, 1+next);
            }
            sb.insert(i, curr.charAt(i));
        }
        map.put(curr, ans);
        return ans;
    }
    
    public int longestStrChain(String[] inputWords) {
        for(String w: inputWords){
            words.add(w);
        }
        Map<String, Integer> map =new HashMap();
        int ans = 1;
        for(String w: inputWords){
            ans = Math.max(ans, recur(map, w));
        }
        return ans;
    }
}