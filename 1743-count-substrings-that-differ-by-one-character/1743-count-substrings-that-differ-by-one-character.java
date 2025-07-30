class Solution {
    public int countSubstrings(String s, String t) {
        int n = s.length(), m = t.length();
        int count = 0;

        // For every pair of positions (i, j) where s[i] != t[j]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    // Count matching chars to the left
                    int left = 0;
                    while (i - left - 1 >= 0 && j - left - 1 >= 0 &&
                           s.charAt(i - left - 1) == t.charAt(j - left - 1)) {
                        left++;
                    }

                    // Count matching chars to the right
                    int right = 0;
                    while (i + right + 1 < n && j + right + 1 < m &&
                           s.charAt(i + right + 1) == t.charAt(j + right + 1)) {
                        right++;
                    }

                    // All combinations of (left+1) * (right+1) substrings
                    count += (left + 1) * (right + 1);
                }
            }
        }

        return count;
    }
}
