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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        if(depth==1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        recur(root,val,1,depth-1);
        return root;
    }
    
    private void recur(TreeNode node, int val, int curr, int d){
        if(node==null)
            return;
        
        if(curr==d){
            TreeNode temp1 = new TreeNode(val);
            temp1.left = node.left;
            
            TreeNode temp2 = new TreeNode(val);
            temp2.right = node.right;
            
            node.left = temp1;
            node.right = temp2;
            
            return;
            
        }
        
        recur(node.left, val, curr+1, d);
        recur(node.right, val, curr+1,d);
    }
}