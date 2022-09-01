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
    int ans = 0;
    public int longestConsecutive(TreeNode root) {
        
        recur(root, Integer.MIN_VALUE, 1);
        return ans;
    }
    
    private void recur(TreeNode root, int prev, int len){
        ans = Math.max(ans, len);
        if(root==null){
            return;
        }
        
        int curr = 1;
        if(root.val==prev+1){
            curr = len+1;
        }
            recur(root.left, root.val, curr);
            recur(root.right, root.val, curr);
        
    }
}