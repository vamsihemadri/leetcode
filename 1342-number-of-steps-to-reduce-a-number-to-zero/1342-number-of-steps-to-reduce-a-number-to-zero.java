class Solution {
    public int numberOfSteps(int num) {
       
        return steps(0,num);
    }
    
    private int steps(int curr, int num){
        if(num==0)
            return curr;
        if(num%2==0)
            return steps(curr+1, num/2);
        return steps(curr+1, num-1);
    }
}