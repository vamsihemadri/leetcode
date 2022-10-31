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
    public int[] treeQueries(TreeNode root, int[] queries) {
        
        Map<Integer, Integer> map = new HashMap();
        recur(root, map);
        
        Queue<TreeNode> q = new LinkedList();
        Map<Integer, List<Integer>> levelMap = new HashMap();
        q.offer(root);
        
        Map<Integer, Integer> map2 = new HashMap();
        
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList();
            for(int i = 0;i<size;i++){
                TreeNode t = q.poll();
                list.add(map.get(t.val));
                map2.put(t.val,level);
                if(t.left!=null)
                    q.offer(t.left);
                if(t.right!=null)
                    q.offer(t.right);
            }
            
            Collections.sort(list, Collections.reverseOrder());
            levelMap.put(level, list);
            level++;
        }
        

        
        int[] ans = new int[queries.length];
        
        for(int i = 0;i<queries.length;i++){
            int val = queries[i];
            
            int tlevel = map2.get(val);
            int hei = map.get(root.val);
            int nodeHeight = map.get(val);
            
            
            if(hei-1==nodeHeight-1+tlevel){
            
            List<Integer> levelList = levelMap.get(tlevel);
            
            if(levelList.size()>1){
                ans[i] = hei-nodeHeight+levelList.get(1)-1;
            }
            else
                ans[i] = hei-nodeHeight-1;
            }else{
                ans[i] = map.get(root.val)-1;
            }
            
        }
        
        return ans;
        
        
    }
    
    
    
    private int recur(TreeNode node, Map<Integer, Integer> map){
        
        if(node==null)
            return 0;
        
        int left = recur(node.left, map);
        int right = recur(node.right, map);
        
        int height = Math.max(left, right)+1;
        map.put(node.val,height);
        return height;
    }
}