class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
            List<Integer> ans = new ArrayList();
        
        for(int i = 1;i<=9;i++){
            recur(i,i,1,n,k,ans);
        }
        
        int size = ans.size();
        int[] arr = new int[size];
        int pos = 0;
        for(int a: ans){
            arr[pos++] = a;
        }
        return arr;
    }
    
    
    
    private void recur(int curr, int last, int len, int n, int k, List<Integer> ans ){
        if(len==n){
            ans.add(curr);
            return;
        }
        
        int next = last+k;
        if(next<10){
            recur(curr*10 + next, next, len+1, n,k,ans);
        }
        next = last-k;
        if(next>=0 && k!=0){
            recur(curr*10 + next, next, len+1, n,k, ans);
        }
    }
}