class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        // Step 1: validate diagonal + symmetry
        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] != lcp[j][i]) return "";
            }
        }

        // Step 2: build string greedily
        char[] word = new char[n];
        Arrays.fill(word, '#');

        char ch = 'a';

        for (int i = 0; i < n; i++) {
            if (word[i] == '#') {
                if (ch > 'z') return "";

                for (int j = i; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        word[j] = ch;
                    }
                }
                ch++;
            }
        }

        // Step 3: validate using LCP logic
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] == word[j]) {
                    int expected = 1;
                    if (i + 1 < n && j + 1 < n) {
                        expected += lcp[i + 1][j + 1];
                    }
                    if (lcp[i][j] != expected) return "";
                } else {
                    if (lcp[i][j] != 0) return "";
                }
            }
        }

        return new String(word);
    }
}