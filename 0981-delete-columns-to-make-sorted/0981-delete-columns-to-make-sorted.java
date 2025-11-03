class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        int count = 0;

        for (int col = 0; col < n; col++) {
            for (int row = 1; row < m; row++) {
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
