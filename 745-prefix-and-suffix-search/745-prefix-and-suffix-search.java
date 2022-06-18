class WordFilter {

    TrieNode pre;
    TrieNode suf;
    public WordFilter(String[] words) {
        
        Comparator cmp = new CustomComparator(words);
        pre = new TrieNode(cmp);
        suf = new TrieNode(cmp);
        
        Set<String> added = new HashSet();
        
        for(int i = words.length-1;i>=0;i--){
            if(!added.contains(words[i])){
                insertIntoTrie(i,pre,words[i],0,cmp);
                insertIntoTrie(i,suf,reverse(words[i]),0,cmp);
                added.add(words[i]);
            }
        }
        
    }
    
    private String reverse(String word){
        return new StringBuilder().append(word).reverse().toString();
    }
    
    public int f(String prefix, String suffix) {
        PriorityQueue<Integer> one = new PriorityQueue(search(prefix, pre));
        PriorityQueue<Integer> two = new PriorityQueue(search(reverse(suffix),suf));
        
        int largest = -1;

        while(!one.isEmpty() && !two.isEmpty()){
            
            int o = one.peek();
            int t = two.peek();
            
            if(o==t)
                return o;
            
            if(o>t)
                one.poll();
            else
                two.poll();
        }
        
        
        return largest;
    }
    
    private PriorityQueue<Integer> search(String word, TrieNode node){
        
        for(char ch : word.toCharArray()){
            if(!node.map.containsKey(ch)){
                return new PriorityQueue();
            }
            node = node.map.get(ch);
        }
        return node.pq;
    }
    
    private void insertIntoTrie(int index,TrieNode node, String word, int pos, Comparator cmp){
        
        if(pos == word.length())
            return;
        
        if(!node.map.containsKey(word.charAt(pos))){
            node.map.put(word.charAt(pos),new TrieNode(cmp));
        }
        
        //node.pq.offer(pos);
        node = node.map.get(word.charAt(pos));
        //node.set.add(index);
        node.pq.offer(index);
        
        insertIntoTrie(index,node,word,pos+1,cmp);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
class TrieNode{
    
    Map<Character, TrieNode> map;
    PriorityQueue<Integer> pq;
    Set<Integer> set = new HashSet();
    
    public TrieNode(Comparator comparator){
        map = new HashMap();
        pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        set = new HashSet();
    }
    
}

class CustomComparator implements Comparator<Integer>{
    
    String[] words;
    public CustomComparator(String[] w){
        words = w;
    }
    public int compare(Integer a, Integer b){
        return words[b].length()-words[a].length();
    }
}