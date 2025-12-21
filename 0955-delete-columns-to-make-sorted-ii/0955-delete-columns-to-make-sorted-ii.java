class Solution {
    public int minDeletionSize(String[] strs) {
        int r = strs.length, c = strs[0].length();

        boolean[] check = new boolean[r - 1];
        int count = 0;

        for (int col = 0; col < c; col++) {
            boolean skip = false;

            for (int i = 0; i < r - 1; i++) {
                if (!check[i] && strs[i].charAt(col) > strs[i + 1].charAt(col)) {
                    skip = true;
                    break;
                }
            }

            if (skip) {
                count++;
                continue;
            }

            for (int i = 0; i < r - 1; i++) {
                if (!check[i] && strs[i].charAt(col) < strs[i + 1].charAt(col)) {
                    check[i] = true;
                }
            }
        }

        return count;
    }
}
