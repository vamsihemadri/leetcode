class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<Integer> first = new ArrayList();
        List<List<Integer>> ans = new ArrayList();
        first.add(1);
        ans.add(first);
        if(numRows==1)
            return ans;
        List<Integer> sec = new ArrayList();
        sec.add(1);
        sec.add(1);
        ans.add(sec);
        if(numRows==2)
            return ans;
        
        int curr = 3;
        List<Integer> prev = sec;
        while(curr<=numRows){
            List<Integer> currRow = new ArrayList();
            currRow.add(1);
            
            int pos = 1;
            while(pos<curr-1){
                currRow.add(prev.get(pos)+prev.get(pos-1));
                pos++;
            }
            currRow.add(1);
            
            prev = currRow;
            
            ans.add(currRow);
            curr++;
        }
        return ans;
    }
}