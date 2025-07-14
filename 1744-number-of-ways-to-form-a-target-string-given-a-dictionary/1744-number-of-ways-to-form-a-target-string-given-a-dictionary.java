class Solution {
    static final int MOD = 1_000_000_007;

    public int numWays(String[] words, String target) {
        int wordLen = words[0].length();
        int targetLen = target.length();

        // Precompute frequency of each character in each column
        int[][] freq = new int[wordLen][26];
        for (String word : words) {
            for (int col = 0; col < wordLen; col++) {
                freq[col][word.charAt(col) - 'a']++;
            }
        }

        // dp[j] = number of ways to form target[0...j]
        long[] dp = new long[targetLen + 1];
        dp[0] = 1;

        // Go through each column of words
        for (int col = 0; col < wordLen; col++) {
            // Traverse backwards through target so we don’t overwrite early values
            for (int j = targetLen - 1; j >= 0; j--) {
                char c = target.charAt(j);
                dp[j + 1] = (dp[j + 1] + dp[j] * freq[col][c - 'a']) % MOD;
            }
        }

        return (int) dp[targetLen];
    }
}
