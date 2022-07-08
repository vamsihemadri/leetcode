/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        
        Node ans = null;
        Node curr = node;
        while(curr.parent!=null){
            curr = curr.parent;
        }
        Node prev = null;
        
        while(curr!=null){
            if(prev==node)
                ans=curr;
            if(curr.left==null){
                prev= curr;
                curr = curr.right;
            }else{
                Node pred = findPred(curr);
                if(pred==node){
                    ans = curr;
                }
                if(pred.right==null){
                    pred.right = curr;
                    curr = curr.left;
                }else{
                    pred.right = null;
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
    
    private Node findPred(Node node){
        
        Node pred = node.left;
        while(pred.right!=null && pred.right!=node){
            pred= pred.right;
        }
        return pred;
    }
}