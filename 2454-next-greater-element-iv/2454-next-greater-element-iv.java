class Solution {
    public int[] secondGreaterElement(int[] nums) {
        
        int n = nums.length;
        
        ArrayDeque<Integer> deq = new ArrayDeque();
        
        List<List<Integer>> ge = new ArrayList();
        IntStream.range(0,n).forEach(i->ge.add(new ArrayList()));
        
        for(int i= n-1;i>=0;i--){
            while(!deq.isEmpty() && nums[deq.getFirst()]<=nums[i])
                deq.pollFirst();
            
            if(!deq.isEmpty()){
                int top = deq.getFirst();
                ge.get(top).add(i);
            }
            
            
            deq.offerFirst(i);
        }
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        
        // pq of elements for which the first greater element has been found. 
        
        
        int[] ans= new int[n];
        Arrays.fill(ans, -1);
        
        for(int i = 0;i<n;i++){
            // this is the second greater element for elements for which the first greater element has been found
            // and smaller than this and for which second ge has not been found yet. 
            
            // since smaller than this, min heap. 
            
            // pq on the element, but need the index for the ans...hence array.
            
            while(!pq.isEmpty() && pq.peek()[0]<nums[i])
                ans[pq.poll()[1]] = nums[i];
            
            // only put in pq, the elements for which the current element is ge.
            for(int j:ge.get(i))
                pq.offer(new int[]{nums[j],j});
        }
        
        return ans;
    }
}