class Solution {
    public int candy(int[] ratings) {
        
        int len =ratings.length;
        int[] ans = new int[len];
        PriorityQueue<Val> pq = new PriorityQueue<Val>(new CustomComparator());
        for(int i = 0;i<len;i++){
            pq.offer(new Val(i,ratings[i]));
        }
        
        int toReturn= 0;
        while(!pq.isEmpty()){
            Val val = pq.poll();
            int min = getMin(val.pos, ans, ratings);
            ans[val.pos] = min+1;
            toReturn+=min+1;
        }
        return toReturn;
    }
    
    private int getMin(int pos, int[] ans, int[] ratings){
        int min = 0;
        if(pos>0 && ratings[pos-1]<ratings[pos]){
            min = Math.max(ans[pos-1],min);
        }
        if(pos<ratings.length-1 && ratings[pos+1]<ratings[pos]){
            min = Math.max(ans[pos+1],min);
        }
        return min;
    }
}

class Val{
    int pos;
    int rating;
    public Val(int pos, int rating){
        this.pos = pos;
        this.rating = rating;
    }
}

class CustomComparator implements Comparator<Val>{
    public int compare(Val a, Val b){
        return a.rating-b.rating;
    }
}