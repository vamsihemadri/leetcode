class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        AnsWrapper ans = new AnsWrapper();
        int sum = 0;
        for(int n :matchsticks ){
            sum+=n;
        }
        if(sum%4!=0)
            return false;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        recur(0,matchsticks,0,0,0,0,ans, sum/4);
        return ans.val;
    }
    private void reverse(int[] arr){
        int len = arr.length;
        int left = 0;
        int right = len-1;
        while(left<right){
            int t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
            
            left++;
            right--;
        }
    }
    
    private void recur(int pos, int[] arr, int a, int b, int c, int d, AnsWrapper ans, int max){
        if(ans.val)
            return;
        if(pos==arr.length){
            if(a==b && b==c && c==d)
                ans.val = true;
            return;
        }
        if(a+arr[pos]<=max && !ans.val)
            recur(pos+1, arr, a+arr[pos], b,c,d,ans,max);
        if(b+arr[pos]<=max && !ans.val)
            recur(pos+1, arr, a,b+arr[pos],c,d,ans,max);
        if(c+arr[pos]<=max && !ans.val)
            recur(pos+1, arr, a, b, c+arr[pos], d, ans,max);
        if(d+arr[pos]<=max && !ans.val)
            recur(pos+1, arr, a,b,c, d+arr[pos],ans,max);
    }
}

class AnsWrapper{
    
    boolean val;
    public AnsWrapper(){
        val = false;
    }
}