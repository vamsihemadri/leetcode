class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque();
        stack.offerLast(-1);
        int ans = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.offerLast(i);
            }else{
                stack.removeLast();
                if(stack.isEmpty()){
                    stack.offerLast(i);
                }else{
                    ans = Math.max(ans,i-stack.getLast());
                }
            }
        }
        return ans;
    }
}