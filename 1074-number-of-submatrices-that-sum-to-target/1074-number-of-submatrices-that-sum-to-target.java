class Solution {
    int[][] P;
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n= matrix[0].length;
        
        P = new int [m+1][n+1];
        
        for(int i =0;i<m;i++){
            for(int j= 0;j<n;j++){
                P[i+1][j+1] = P[i+1][j] + P[i][j+1] + matrix[i][j] - P[i][j];
            }
        }
        
        int ans = 0;
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j] == target)
                    ans++;
                for(int u = i;u<m;u++){
                    for(int v = j;v<n;v++){
                        if(u==i && v==j){
                            continue;
                        }
                        if(get(u,v,i,j)==target){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
    
    private int get(int r2,int c2, int r1, int c1){
        return P[r2+1][c2+1] - P[r2+1][c1]-P[r1][c2+1]+P[r1][c1];
    }
}