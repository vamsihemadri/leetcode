class Solution {
    public int shortestWay(String source, String target) {
        
        
        Map<Character, TreeSet<Integer>> map = new HashMap();
        
        for(int i = 0;i<source.length();i++){
            char ch = source.charAt(i);
            map.computeIfAbsent(ch,k->new TreeSet<Integer>());
            map.get(ch).add(i);
        }
        int count = 1;
        int i =0;
        int pos = -1;
        while(i<target.length()){
            char ch = target.charAt(i);
            if(!map.containsKey(ch))
                return -1;
            Integer targetPos= map.get(ch).higher(pos);
            if(targetPos==null){
                count++;
                pos=-1;
                continue;
            }
            pos = targetPos;
            i++;
        }
        return count;
    }
}