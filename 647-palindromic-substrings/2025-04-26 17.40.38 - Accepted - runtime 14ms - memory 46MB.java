class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            res++;
        }

        for (int i = 0; i < n; i++){
            for (int j = i - 1; j >= 0; j--){
                if (s.charAt(i) == s.charAt(j) && (j + 1 == i || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    res++;
                }
            }
        }
        return res;
    }
}