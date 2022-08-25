class Solution {
    public boolean canConstruct(String r, String m) {
        
        Map<Character, Integer> map1 = new HashMap();
        Map<Character, Integer> map2 = new HashMap();
        
        pop(r,map1);
        pop(m,map2);
        
        for(char s: r.toCharArray()){
            int count1 = map1.getOrDefault(s,0);
            int count2 = map2.getOrDefault(s,0);
            
            if(count1<=count2){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    
    
    private void pop(String s, Map<Character, Integer> map){
        for(char c: s.toCharArray()){
            int count = map.getOrDefault(c,0)+1;
            map.put(c,count);
        }
    }
}