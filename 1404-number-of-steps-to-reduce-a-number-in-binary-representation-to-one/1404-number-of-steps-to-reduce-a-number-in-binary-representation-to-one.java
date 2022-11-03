class Solution {
    public int numSteps(String s) {
        
        
        List<Character> arr = s.chars().mapToObj(e -> (char)e).collect(Collectors.toList());//0
        
        int count = 0;
        
        while(arr.size()>1){
            count++;
            if(arr.get(arr.size()-1)=='1'){
                arr = addOne(arr);
            }else{
                arr.remove(arr.size()-1);//1
            }
        }
        
        return count;
    }
    
    
    private List<Character> addOne(List<Character> list){
        int pos = list.size()-1;
        
        while(pos>=0){
            if(list.get(pos)=='0'){
                break;
            }else{
                pos--;
            }
        }
        
        if(pos==-1){
            list.add(0,'1');//2
            pos++;
        }else{
            list.set(pos,'1');
            pos++;
        }
        while(pos<list.size()){
            list.set(pos++,'0');//3
        }
        return list;
        
    }
}