class Solution {
    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;
        
        int[][] visited1 = new int[m][n];
        int[][] visited2 = new int[m][n];
        for(int i = 0;i<m;i++){
            dfsVisit(i,0,visited1,heights,1);
            dfsVisit(i,n-1,visited2, heights,1);
        }
        for(int j = 0;j<n;j++){
            dfsVisit(0,j,visited1,heights,1);
            dfsVisit(m-1,j,visited2, heights, 1);
        }
        List<List<Integer>> list = new ArrayList();
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(visited1[i][j] == 1&& visited2[i][j]==1)
                    list.add(Arrays.asList(i,j));
            }
        }
        
        return list;
    }
    
    private void dfsVisit(int i, int j, int[][] visited, int[][] heights, int visit){
        visited[i][j] = visit;
        
        int m = heights.length;
        int n = heights[0].length;
        
        for(int d = 0;d<dir.length;d++){
            int newX = i + dir[d][0];
            int newY = j + dir[d][1];
            
            if(newX>=0 && newX<m && newY>=0 && newY<n){
                if(visited[newX][newY]==0 && heights[newX][newY]>=heights[i][j])
                    dfsVisit(newX, newY, visited, heights, visit);
            }
        }
        
    }
}