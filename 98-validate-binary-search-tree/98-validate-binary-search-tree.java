/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return recur(root).isBst;
    }
    
    private Val recur(TreeNode root){
        if(root==null)
            return new Val(true);
        
        Val left = recur(root.left);
        Val right = recur(root.right);
        
        boolean isBst = left.isBst && right.isBst&& left.max < (long) root.val && (long) root.val < right.min;
        
        Val val = new Val(isBst);
        
        val.min = Math.min(left.min,Math.min((long) root.val,right.min));
        
        val.max = Math.max(right.max,Math.max( (long)root.val, left.max));
        
        return val;
    }
    
    
}

class Val{
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;
    boolean isBst;
    public Val(boolean isBst){
        this.isBst = isBst;
    }
}