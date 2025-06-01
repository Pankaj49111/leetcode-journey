class NumMatrix {
    int[][] arr;
    public NumMatrix(int[][] matrix) {
        this.arr = matrix;
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        int sum=0;
        for(int i=r1; i<=r2; i++){
            for(int j=c1; j<=c2; j++){
                sum += arr[i][j];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */