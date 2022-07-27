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
    public void flatten(TreeNode root) {
        
        TreeNode node = root;
        while(node!=null){
            if(node.left!=null){
                TreeNode pred = getPred(node);
                
                TreeNode next = node.right;
                
                pred.right = next;
                node.right = node.left;
                node.left=null;
                
                
            }
            node = node.right;
        }
    }
    
    private TreeNode getPred(TreeNode node){
        TreeNode pred = node.left;
        while(pred.right!=null){
            pred= pred.right;
        }
        return pred;
    }
}