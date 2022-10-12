class Solution {
    public int largestRectangleArea(int[] heights) {
        
        
        int len = heights.length;
        
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        
        
        int ans = 0;
        
        int i = 0;
        for(i = 0;i<len;i++){
            
            while(stack.peek()!=-1 && heights[stack.peek()]>= heights[i]){
                int ch = heights[stack.pop()];
                int cw = i-stack.peek()-1;
                
                ans = Math.max(ans, cw*ch);
            }
            
            stack.push(i);
            
        }
        
        while(stack.peek()!=-1){
            int ch = heights[stack.pop()];
            int cw = i-stack.peek()-1;
            ans = Math.max(ans, cw*ch);
        }
        
        return ans;
    }
}