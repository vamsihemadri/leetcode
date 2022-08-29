class Solution {
    int m,n;
    public int numIslands(char[][] grid) {
        
        
        this.m = grid.length;
        this.n = grid[0].length;
        
        UnionFind uf = new UnionFind(m*n);
        
        int[][] nei = {{-1, 0}, {0, -1},{1,0},{0,1}};
        
        
        


        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]=='1'){
                    for(int k = 0;k<nei.length;k++){
                        int newx = i + nei[k][0];
                        int newy = j+ nei[k][1];
                        if(newx>=0 && newx<m && newy >=0 && newy<n && grid[newx][newy]=='1'){
                            uf.union(foo(i,j),foo(newx, newy));
                        }
                    }
                }
            }
        }
        
        Set<Integer> roots = new HashSet();
        
        // for(int i = 0;i<m;i++)
        //     for(int j = 0;j<n;j++){
        //         int idx = foo(i,j);
        //         int root = uf.root(idx);
        //         System.out.println(idx + "-->" + root);
        //         }
        
        
        
        for(int i = 0;i<m;i++)
            for(int j = 0;j<n;j++){
                if(grid[i][j]=='1'){
                    roots.add(uf.root(foo(i,j)));
                }
            }
        
        
        return roots.size();
    }
    
    private int foo(int i, int j){
        return i*n+j;
    }
}

    class UnionFind{
    
    int[] parent;
    int[] rank;
    
    public UnionFind(int k){
        int l = k;
        
        parent = new int[l];
        rank = new int[l];
        
        for(int i = 0;i<l;i++){
            rank[i] = 0;
            parent[i] = i;
        }
    }
    
    public int root(int i){
        if(parent[i] == i)
            return i;
        parent[i] = root(parent[i]);
        return parent[i];
    }
    
    public void union(int a, int b){
        int rootA = root(a);
        int rootB = root(b);
        if(rootA== rootB)
            return;
        if(rank[rootA]<rank[rootB]){
            parent[rootA] = parent[rootB];
            //rank[rootB]+=rank[rootA];
        }else if(rank[rootB] < rank[rootA]){
            parent[rootB] = parent[rootA];
            //rank[rootA]+=rank[rootB];
        }else{
            parent[rootA] = parent[rootB];
            rank[rootB]+=1;
        }
    }
        
        public void print(){
            int v = 1;
        }
}



