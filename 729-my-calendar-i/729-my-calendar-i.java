class MyCalendar {
    
    TreeSet<int[]> set;

    public MyCalendar() {
        set = new TreeSet<int[]>((a,b)->a[1]-b[1]);
    }
    
    public boolean book(int start, int end) {
        Iterator<int[]> it = set.tailSet(new int[]{0,start}).iterator();
        while(it.hasNext()){
            int[] arr = it.next();
            if(arr[0]>end)
                break;
            if(arr[0]==end){
                end = arr[1];
                it.remove();
                break;
            }
            
            if(arr[1]==start){
                //it.remove();
                start = arr[0];
                continue;
            }
            
            
            return false;
            
        }
        
        set.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */