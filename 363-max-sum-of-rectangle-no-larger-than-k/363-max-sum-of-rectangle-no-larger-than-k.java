class Solution {
    int ans = Integer.MIN_VALUE;
    private void foo(int[] arr, int k){
        int sum = 0;
        TreeSet<Integer> set= new TreeSet();
        set.add(0);
        for(int n: arr){
            sum+=n;
            
            Integer num = set.ceiling(sum-k);
            if(num!=null&&sum-num>ans)
                ans = sum-num;
            set.add(sum);
        }
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        
        int[] rowSum = new int[matrix[0].length];
        
        for(int i = 0;i<matrix.length;i++){
            Arrays.fill(rowSum,0);
            
            for(int row = i;row<matrix.length;row++){
                for(int col = 0;col<matrix[0].length;col++){
                    rowSum[col]+=matrix[row][col];
                }
                
                foo(rowSum,k);
                if(ans==k)
                    return ans;
            }
        }
        return ans;
    }
}