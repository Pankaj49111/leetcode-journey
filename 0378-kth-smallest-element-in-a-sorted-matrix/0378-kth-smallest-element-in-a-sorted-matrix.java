class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int cnt = countLE(matrix, mid);
            if (cnt < k) {
                low = mid + 1; // move to the right part
            } else {
                high = mid; // mid could be the answer, search in the left part, including mid
            }
        }

        return high; // or high, since low == high here
    }

    private int countLE(int[][] matrix, int mid) {
        int count = 0;
        int n = matrix.length;
        int row = n - 1; // Start from the last row
        int col = 0; // Start from the first column

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                count += (row + 1); // All elements above this element in the column are <= mid
                col++; // Move right to the next column
            } else {
                row--; // Move up to the previous row
            }
        }

        return count;
    }
}