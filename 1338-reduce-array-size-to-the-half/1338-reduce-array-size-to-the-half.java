class Solution {
    public int minSetSize(int[] arr) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->b[1]-a[1]);
        Map<Integer, Integer> map = new HashMap();
        for(int n: arr){
            int count = map.getOrDefault(n,0)+1;
            map.put(n,count);
        }
        for(Integer k: map.keySet()){
            pq.offer(new int[]{k,map.get(k)});
        }
        
        int ans = 0;
        int count = arr.length;
        while(count>arr.length/2 && !pq.isEmpty()){
            int[] top = pq.poll();
            ans++;
            count-=top[1];
        }
        
        
        return ans;
    }
}