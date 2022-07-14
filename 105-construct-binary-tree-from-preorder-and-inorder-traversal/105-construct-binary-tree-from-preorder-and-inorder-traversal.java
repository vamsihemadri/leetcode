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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int pos = 0;
        Map<Integer, Integer> inorderPosMap = new HashMap();
        while(pos<inorder.length){
            inorderPosMap.put(inorder[pos],pos);
            pos++;
        }
        IntWrapper idx = new IntWrapper();
        TreeNode node = recur(0,inorder.length-1,idx,inorderPosMap, preorder);
        return node;
    }
    private TreeNode recur(int left, int right,IntWrapper preIdx, Map<Integer, Integer> inorderPosMap, int[] preorder){
        
        if(left==right){
            TreeNode node = new TreeNode(preorder[preIdx.val++]);
            return node;
        }
        if(left>right)
            return null;
        
        TreeNode node = new TreeNode(preorder[preIdx.val++]);
        int pos = inorderPosMap.get(node.val);
        node.left = recur(left, pos-1, preIdx, inorderPosMap, preorder);
        node.right = recur(pos+1, right, preIdx, inorderPosMap, preorder);
        return node;
        
    }
}

class IntWrapper{
    int val;
    public IntWrapper(){
        val = 0;
    }
}