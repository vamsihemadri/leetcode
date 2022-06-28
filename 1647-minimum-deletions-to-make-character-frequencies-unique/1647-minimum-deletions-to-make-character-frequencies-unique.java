class Solution {
    public int minDeletions(String s) {
        
        Map<Character, Integer> countMap = new HashMap();
        
        for(char ch : s.toCharArray()){
            int count = countMap.getOrDefault(ch,0);
            countMap.put(ch, count+1);
        }
        
        int ans = 0;
        
        Set<Integer> set = new HashSet();
        for(char ch : countMap.keySet()){
            int count = countMap.get(ch);
            if(!set.contains(count)){
                set.add(count);
            }else{
               
                while(count>0 && set.contains(count)){
                    count--;
                    ans++;
                }
                set.add(count);
            }
        }
        
        return ans;
    }
}