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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return recur(root, subRoot);
    }
    
    private boolean recur(TreeNode root1, TreeNode root2){
        if(root1==null)
            return false;
        
        if(root1.val==root2.val){
            if(check(root1, root2))
                return true;
        }
        if(recur(root1.left,root2))
            return true;
        return recur(root1.right, root2);
    }
    
    
    private boolean check(TreeNode node1, TreeNode node2){
        if(node1==null && node2==null)
            return true;
        if(node1==null || node2==null)
            return false;
        
        return node1.val == node2.val && check(node1.left,node2.left) && check(node1.right, node2.right);
    }
}