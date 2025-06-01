class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n]; // dp[i] = length of longest alt. subsequence ending at i
        int[] prev = new int[n]; // prev[i] = previous index in that sequence

        Arrays.fill(dp, 1); // every element alone is a valid subsequence
        Arrays.fill(prev, -1);

        int maxLen = 1;
        int lastIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        // Reconstruct the subsequence
        List<String> result = new ArrayList<>();
        while (lastIndex != -1) {
            result.add(words[lastIndex]);
            lastIndex = prev[lastIndex];
        }

        // Reverse to get correct order
        Collections.reverse(result);
        return result;
    }
}