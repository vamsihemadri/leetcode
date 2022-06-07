class Solution {
    
    
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> q = new LinkedList();
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] dist = new int[m][n];
        for(int i = 0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j,0});
                    dist[i][j] = 0;
                }
            }
        }
        
        int[][] visited = new int[m][n];
        
        while(!q.isEmpty()){
            
            int[] top = q.poll();
            for(int d = 0;d<dirs.length;d++){
                int newX = top[0] + dirs[d][0];
                int newY = top[1]+dirs[d][1];
                
                if(newX>=0 && newX<m && newY>=0 && newY<n && mat[newX][newY]==1){
                    if(visited[newX][newY]==0){
                        dist[newX][newY] = 1+dist[top[0]][top[1]];
                        q.offer(new int[]{newX, newY, dist[newX][newY]});
                        visited[newX][newY]=1;
                    }
                }
            }
        }
        return dist;
    }
}