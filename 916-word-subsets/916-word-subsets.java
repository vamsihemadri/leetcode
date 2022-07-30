class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int i = 0;
        int[] max = new int[26];
        for(String w: words2){
            addInMax(max, getId(w));
        }
        
        List<String> ans = new ArrayList();
        for(String w: words1){
            if(isSubSet(max, getId(w)))
                ans.add(w);
        }
        return ans;
    }
    private void addInMax(int[] max, int[] curr){
        for(int i =0;i<curr.length;i++){
            max[i] = Math.max(max[i], curr[i]);
        }
    }
    boolean isSubSet(int[] sub, int[] sup){
            for(int i = 0 ;i<sub.length;i++){
                if(sub[i]>sup[i])
                    return false;
            }
            return true;
        }
    
    private int[] getId(String w){
        int[] id = new int[26];
        for(char ch : w.toCharArray()){
            id[ch-'a']++;
        }
        return id;
    }
}