class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 1; j < n; j++) {
            if (p.charAt(j) == '*' && dp[0][j - 1]) {
                dp[0][j + 1] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char sc = s.charAt(i);
                char pc = p.charAt(j);

                if (pc == '.' || pc == sc) {
                    dp[i + 1][j + 1] = dp[i][j];
                } 
                else if (pc == '*') {
                    char prev = p.charAt(j - 1);
                    dp[i + 1][j + 1] = dp[i + 1][j - 1]; // zero occurrence
                    if (prev == '.' || prev == sc) {
                        dp[i + 1][j + 1] |= dp[i][j + 1]; // one or more
                    }
                }
            }
        }
        return dp[m][n];
    }
}
