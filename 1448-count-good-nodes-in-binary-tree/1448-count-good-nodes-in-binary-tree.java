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
    
    public int goodNodes(TreeNode root) {
        
        AnsWrapper ansWrapper = new AnsWrapper();
        recur(root, Integer.MIN_VALUE, ansWrapper);
        return ansWrapper.ans;
    }
    
    private void recur(TreeNode node, int maxSoFar,AnsWrapper ansWrapper){
        if(node==null){
            return;
        }
        if(maxSoFar<=node.val)
            ansWrapper.ans++;
        
        maxSoFar = Math.max(maxSoFar, node.val);
        recur(node.left, maxSoFar,ansWrapper);
        recur(node.right, maxSoFar,ansWrapper);
    }
}
class AnsWrapper{
    public int ans;
    
    public AnsWrapper(){
        ans = 0;
    }
}