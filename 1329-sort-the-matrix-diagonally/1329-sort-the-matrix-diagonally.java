class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int m = mat.length;
        int n  = mat[0].length;
        
        int i = m-1;
        int j = 0;
        
        while(i>=0){
            PriorityQueue<Integer> pq = foo(mat, i, j);
            pop(pq,mat, i,j);
            i--;
        }
        
        i = 0;
        j = 1;
        
        while(j<n){
           PriorityQueue<Integer> pq = foo(mat, i, j);
            pop(pq,mat,i,j);
            j++;
        }
        
        return mat;
        
    }
    private void pop(PriorityQueue<Integer> pq, int[][] mat, int i , int j){
        while(!pq.isEmpty()){
            mat[i][j] = pq.poll();
            i++;
            j++;
        }
    }
    private PriorityQueue<Integer> foo(int[][] mat, int i , int j){
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        int m = mat.length;
        int n = mat[0].length;
        
        while(i<m && j<n){
            pq.offer(mat[i][j]);
            i++;
            j++;
        }
        return pq;
    }
}