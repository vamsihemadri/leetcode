class Solution {
    int M;
    int N;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        
        M = m;
        N = n;
        int total = m*n;
        UF uf = new UF(total);
        int[][] dirs = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        
        int[][] grid = new int[m][n];
        int curr = 0;
        List<Integer> ans = new ArrayList();
        
        for(int[] position: positions){
            int x = position[0];
            int y= position[1];
            
            if(grid[x][y]==1){
                ans.add(curr);
                continue;
            }
            grid[x][y] = 1;
            curr++;
            int id1 = getId(x,y);
            
            for(int d = 0;d<dirs.length;d++){
                int newX = x + dirs[d][0];
                int newY = y + dirs[d][1];
                int id2 = getId(newX, newY);
                if(newX>=0&& newX<m && newY>=0 && newY<n){
                    if(grid[newX][newY]==1){
                        if(!uf.isSame(id1,id2 )){
                            uf.union(id1, id2);
                            curr--;
                        }
                    }
                }
            }
            
            ans.add(curr);
        }
        return ans;
    }
    
    private int getId(int x, int y){
        return x*N + y;
    }
}

class UF{
    int[] parent;
    int[] weight;
    
    public UF(int n){
        parent = new int[n];
        weight = new int[n];
        
        for(int i = 0;i<n;i++){
            parent[i] = i;
            weight[i] = 1;
        }
    }
    
    
    public int find(int i){
        int p = parent[i];
        if(p!=i){
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
    
    public boolean isSame(int i, int j){
        int findI = find(i);
        int findJ = find(j);
        return findI==findJ;
    }
    
    public void union(int i, int j){
        
        int findI = find(i);
        int findJ = find(j);
        
        if(findI !=findJ){
            if(weight[findI]<weight[findJ]){
                parent[findI] = findJ;
            }else if(weight[findJ]<weight[findI]){
                parent[findJ] = findI;
            }else{
                parent[findJ] = findI;
                weight[findI]+=1;
            }
        }
    }
}