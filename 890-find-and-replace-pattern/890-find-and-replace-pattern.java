class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> ans = new ArrayList();
        for(String word: words){
            if(isMapping(pattern, word))
                ans.add(word);
        }
        return ans;
    }
    
    
    private boolean isMapping(String p, String w){
        Map<Character, Character> map = new HashMap();
        Set<Character> seen = new HashSet();
        if(p.length()!=w.length())
            return false;
        for(int i = 0;i<p.length();i++){
            char c1 = p.charAt(i);
            char c2 = w.charAt(i);
            
            if(map.containsKey(c1)){
                char m = map.get(c1);
                if(m!=c2)
                    return false;
                continue;
            }
            if(seen.contains(c2))
                return false;
            
            map.put(c1,c2);
            seen.add(c2);
        }
        return true;
    }
}