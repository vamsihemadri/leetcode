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
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> deq = new ArrayDeque();
        List<Integer> ans = new ArrayList();
        
        if(root==null)
            return ans;
        
        deq.offerLast(root);
        
        while(!deq.isEmpty()){
            TreeNode node= deq.removeLast();
            ans.add(node.val);
            if(node.left!=null)
                deq.offerLast(node.left);
            if(node.right!=null)
                deq.offerLast(node.right);
        }
        Collections.reverse(ans);
        return ans;
    }
}