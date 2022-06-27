class Solution {
    public int minPartitions(String n) {
        
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(char ch : n.toCharArray()){
            int i = ch - '0';
            if(i!=0){
                pq.offer(i);
            }
        }
        
        int ans = 0;
        
        while(pq.size()>1){
            int min = pq.poll();
            PriorityQueue<Integer> pq2 = new PriorityQueue();
            while(!pq.isEmpty()){
                int next = pq.poll()-min;
                if(next!=0)
                    pq2.offer(next);
            }
            ans+=min;
            pq = pq2;
        }
        
        return ans + (pq.size()==1?pq.poll():0);
    }
}