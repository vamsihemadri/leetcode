class Solution {
    public boolean isAnagram(String s, String t) {
        
        String id1 = getId(s);
        String id2 = getId(t);
        return id1.equals(id2);
    }
    
    String getId(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new StringBuilder().append(arr).toString();
    }
}