class Solution {
    int n;
    public int maxAreaOfIsland(int[][] grid) {
        
        int m = grid.length;
        this.n = grid[0].length;
        
        UnionFind uf= new UnionFind( m*n);
        int[][] nei= {{1,0},{0,1},{-1,0},{0,-1}};
        
        for(int i = 0;i<m;i++){
            for(int j= 0;j<n;j++){
                if(grid[i][j] == 1){
                    for(int  k =0;k<nei.length;k++){
                        int newx = i + nei[k][0];
                        int newy = j+nei[k][1];
                        if(newx>=0 && newx<m && newy>=0 && newy<n && grid[newx][newy]==1){
                            uf.union(foo(i,j),foo(newx, newy));
                        }
                    }
                }
            }
        }
        
        for(int i = 0;i<m;i++){
            for(int  j =0;j<n;j++){
                uf.root(foo(i,j));
            }
        }
        
        Map<Integer, Integer> map= new HashMap();
        for(int i = 0;i<m;i++)
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1){
                    int parent = uf.parent[foo(i,j)];
                    int count = map.getOrDefault(parent,0);
                    count++;
                    map.put(parent, count);
                }
            }
        
        int ans = 0;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans = Math.max(ans,entry.getValue());
        }
        
        return ans;
        
        
    }
    
    private int foo(int i, int j){
        return i*n + j;
    }
}


class UnionFind {
    
    int[] parent;
    int[] rank;
    
    public UnionFind(int l){
        parent = new int[l];
        rank = new int[l];
        for(int i = 0;i<l;i++){
            rank[i] = 0;
            parent[i] = i;
        }
    }
    
    public int root(int i){
        if(parent[i]==i)
            return i;
        parent[i] = root(parent[i]);
        return parent[i];
    }
    
    public void union(int a, int b){
        int rootA = root(a);
        int rootB = root(b);
        if(rootA== rootB){
            return;
        }else{
            if(rank[rootA]< rank[rootB]){
                parent[rootA] = rootB;
                //rank[rootB]+=rank[rootA];
            }else if(rank[rootB] < rank[rootA]){
                parent[rootB] = rootA;
                //rank[rootA]+=rank[rootB];
            }else{
                parent[rootB] = rootA;
                rank[rootA]+=1;
            }
        }
    }
}