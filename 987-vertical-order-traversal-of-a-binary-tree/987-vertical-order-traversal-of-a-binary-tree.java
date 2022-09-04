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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap();
        verticalOrder(root, 0,0,map);
        
        List<List<Integer>> ans = new ArrayList();
        for(Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry: map.entrySet()){
            TreeMap<Integer, List<Integer>> colMap = entry.getValue();
            List<Integer> col = new ArrayList();
            for(Map.Entry<Integer, List<Integer>> colEntry: colMap.entrySet()){
                col.addAll(colEntry.getValue());
            }
            ans.add(col);
        }
        
        return ans;
    }
    
    
    private void verticalOrder(TreeNode root, int row, int col,    TreeMap<Integer, TreeMap<Integer, List<Integer>>> map){
        if(root==null){
            return;
        }
        TreeMap<Integer, List<Integer>> colMap = map.getOrDefault(col, new TreeMap());
        List<Integer> rowList = colMap.getOrDefault(row, new ArrayList());
        rowList.add(root.val);
        Collections.sort(rowList);
        colMap.put(row, rowList);
        
        map.put(col, colMap);
        
        verticalOrder(root.left, row+1 , col-1,map);
        verticalOrder(root.right,row+1 , col+1,map);
        
    }
}