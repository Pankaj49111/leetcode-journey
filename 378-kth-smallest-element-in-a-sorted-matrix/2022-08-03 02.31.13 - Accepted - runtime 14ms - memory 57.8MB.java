class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int r = matrix.length, c = matrix[0].length;
        int[] arr = new int[r*c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                arr[c*i+j] = matrix[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[k-1];
    }
}