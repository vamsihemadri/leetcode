class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
        int left = 0;
        
        Map<Character, Integer> countMap = new HashMap();
        
        int ans = 0;
        
        for(int right= 0;right<s.length();right++){
            char ch = s.charAt(right);
            
            if(countMap.containsKey(ch)){
                
                while(countMap.containsKey(ch)){
                    char leftChar = s.charAt(left);
                    int count = countMap.get(leftChar);
                    
                    if(count==1)
                        countMap.remove(leftChar);
                    else
                        countMap.put(leftChar, count-1);
                    
                    left++;
                }
                
            }
            
            countMap.put(ch,1);
            
            ans=  Math.max(ans, right-left+1);    
            
            
            
        }
        return ans;
    }
}