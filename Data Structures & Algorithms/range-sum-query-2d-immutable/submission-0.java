class NumMatrix {
    private int[][] dp;

    public NumMatrix(int[][] m) {
        dp=new int[m.length+1][m[0].length+1];
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                dp[i+1][j+1]=m[i][j]+dp[i][j+1]+dp[i+1][j]-dp[i][j];
                System.out.print(dp[i+1][j+1]+" ");
            }
            System.out.println();
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1]-dp[row2+1][col1]-dp[row1][col2+1]+dp[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */