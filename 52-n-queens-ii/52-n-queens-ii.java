class Solution {
    
    List<List<String>> ans = new ArrayList();
    int N;
    
    public int totalNQueens(int n) {
        
        N = n;
        char[][] grid = new char[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                grid[i][j] = '.';
            }
        }
        
        backTrack(0,new HashSet(),new HashSet(), new HashSet(), grid);
        return ans.size();
    }
    
    private void addGridToAns(char[][] grid){
        List<String> table = new ArrayList();
        for(int i = 0;i<N;i++){
            String row = new String(grid[i]);
            table.add(row);
        }
        ans.add(table);
    }
    
    private void backTrack(int row, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiagonals, char[][] grid){
        if(row==N){
            addGridToAns(grid);
        }
        
        for(int i = 0;i<N;i++){
            int diagonal = row-i;
            int antiDiagonal = row+i;
            if(cols.contains(i) || diagonals.contains(diagonal) || antiDiagonals.contains(antiDiagonal)){
                continue;
            }
            grid[row][i] = 'Q';
            cols.add(i);
            diagonals.add(diagonal);
            antiDiagonals.add(antiDiagonal);
            backTrack(row+1, cols, diagonals, antiDiagonals,grid);
            
            grid[row][i] = '.';
            diagonals.remove(diagonal);
            antiDiagonals.remove(antiDiagonal);
            cols.remove(i);
            
        }
        
        
    }
}