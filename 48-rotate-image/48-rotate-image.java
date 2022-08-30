class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
        
    }
    private void reverse(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int temp = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n/2;j++){
                temp = mat[i][j];
                mat[i][j] = mat[i][n-1-j];
                mat[i][n-1-j] = temp;
            }
        }
    }
    
    
    private void transpose(int[][] mat){
        int n = mat.length;
        int temp = 0;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                temp = mat[j][i];
                mat[j][i] = mat[i][j];
                mat[i][j] = temp;
            }
        }
        

    }
}