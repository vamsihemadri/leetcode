class Solution {
    Map<String, Integer> countMap = new HashMap();
    int k;
    int totalSize;
    int eachSize;
    
    private boolean check(int i,String s){
        Map<String, Integer> tempMap = new HashMap(countMap);
        int count = 0;
        for(int j = i;j<i+totalSize;j+=eachSize){
            String w = s.substring(j,j+eachSize);
            int req = tempMap.getOrDefault(w,0);
            if(req!=0){
                tempMap.put(w,req-1);
                count++;
            }else{
                break;
            }
        }
        
        return count==k;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        
        k = words.length;
        eachSize = words[0].length();
        totalSize = k * eachSize;
        
        for(String w : words){
            int count = countMap.getOrDefault(w,0)+1;
            countMap.put(w,count);
        }
        List<Integer> ans = new ArrayList();
        for(int i = 0;i<s.length()-totalSize+1;i++){
            if(check(i,s))
                ans.add(i);
        }
        return ans;
        
    }
}