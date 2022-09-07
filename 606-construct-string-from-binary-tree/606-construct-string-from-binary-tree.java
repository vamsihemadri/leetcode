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
    public String tree2str(TreeNode root) {
        return recur(root).toString();
    }
    
    private StringBuilder recur(TreeNode root){
        if(root==null)
            return new StringBuilder();
        StringBuilder curr = new StringBuilder();
        curr.append(root.val);
        StringBuilder left = recur(root.left);
        StringBuilder right = recur(root.right);
        if(left.length()==0 && right.length()==0){
            return curr;
        }
            curr.append('(');
            curr.append(left);
            curr.append(')');
        if(right.length()==0){
            return curr;
        }
        curr.append('(');
        curr.append(right);
        curr.append(')');
        return curr;
    }
}