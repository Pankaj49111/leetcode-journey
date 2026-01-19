class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] =   mat[i - 1][j - 1]
                            + prefix[i - 1][j]
                            + prefix[i][j - 1]
                            - prefix[i - 1][j - 1];
            }
        }

        int left = 1, right = Math.min(m, n), ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            boolean found = false;

            for (int i = 0; i + mid <= m && !found; i++) {
                for (int j = 0; j + mid <= n; j++) {
                    int sum = prefix[i + mid][j + mid]
                            - prefix[i][j + mid]
                            - prefix[i + mid][j]
                            + prefix[i][j];
                    if (sum <= threshold) {
                        found = true;
                        break;
                    }
                }
            }

            if (found) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}