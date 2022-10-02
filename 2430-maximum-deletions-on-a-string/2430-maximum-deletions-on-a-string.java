class Solution {
    Map<Integer, Integer> map = new HashMap();
    public int deleteString(String s) {
        return recur(0,s);
    }
    
    private boolean check(int pos, int len, String s){
        
        boolean ans = true;
        int i = 1;
        while(i<=len){
            if(s.charAt(pos)==s.charAt(pos+len)){
                i++;
                pos++;
                continue;
            }else{
                return false;
            }
        }
        return ans;
    }
    
    private boolean checkAllEqual(int pos, String s){
        int len = s.length();
        
        char c = s.charAt(pos);
        while(pos<len){
            if(s.charAt(pos)!=c)
                return false;
            pos++;
        }
        return true;
    }
    
    
    
    private int recur(int pos, String s){
        if(pos==s.length()-1)
            return 1;
        if(checkAllEqual(pos,s)){
            map.put(pos,s.length()-pos);
            return s.length()-pos;
        }
        if(map.containsKey(pos))
            return map.get(pos);
        
        int ans = 1;
        
        int len = s.length();
        for(int i=1;i<=(len-pos)/2;i++){
            if(check(pos,i, s)){
                ans = Math.max(ans, 1+recur(pos+i, s));
            }
        }
        
        
        map.put(pos, ans);
        return ans;
    }
}