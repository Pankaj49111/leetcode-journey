class Solution {
    public int countSubstrings(String s, String t) {
        int count = 0;
        int n = s.length();
        int m = t.length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int mismatch = 0;
                // Try substrings of increasing length
                for (int k = 0; i + k < n && j + k < m; k++) {
                    char cs = s.charAt(i + k);
                    char ct = t.charAt(j + k);
                    if (cs != ct) {
                        mismatch++;
                    }
                    if (mismatch > 1) break; // Only allow exactly one mismatch
                    if (mismatch == 1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}