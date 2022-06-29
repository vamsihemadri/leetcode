class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        int len = people.length;
        
        List<int[]> list = new ArrayList();
        
        Arrays.sort(people, new CustomComparator());
        
        
        int[][] ans= new int[len][2];
        
        int pos = 0;
        while(pos<len){
            list.add( people[pos][1],people[pos]);
            
            pos++;
        }
        
        pos = 0;
        while(pos<len){
            ans[pos] = list.get(pos);
            pos++;
        }
        
        return ans;
    }
}

class CustomComparator implements Comparator<int[]>{
    
    public int compare(int[] a, int[] b){
        if(a[0]!=b[0])
            return b[0]-a[0];
        
        return a[1]-b[1];
    }
}