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
    public TreeNode pruneTree(TreeNode root) {
        return recur(1, root);
    }
    
    
    private TreeNode recur(int val, TreeNode node){
        if(node==null)
            return null;
        TreeNode left = recur(val, node.left);
        TreeNode right = recur(val, node.right);
        
        if(left==null && right==null && node.val!=val)
            return null;
        
        node.left= left;
        node.right = right;
        return node;
    }
}