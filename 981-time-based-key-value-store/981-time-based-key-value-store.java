class TimeMap {
    
    Map<String, ArrayList<Val>> map;
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        ArrayList<Val> list = map.getOrDefault(key, new ArrayList());
        list.add(new Val(value, timestamp));
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        String empty = "";
        if(!map.containsKey(key))
            return empty;
        ArrayList<Val> list= map.get(key);
        int low = 0;
        int high = list.size();
        
        while(low+1<high){
            int mid = low + (high-low)/2;
            
            if(isValid(list, mid, timestamp))
                low = mid;
            else
                high = mid;
        }
        
        if(list.get(low).timestamp<=timestamp)
            return list.get(low).value;
        return empty;
    }
    
    private boolean isValid(ArrayList<Val> list, int pos, int timestamp){
        if(list.get(pos).timestamp<=timestamp)
            return true;
        return false;
    }
}

class Val{
    String value;
    int timestamp;
    
    public Val(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */