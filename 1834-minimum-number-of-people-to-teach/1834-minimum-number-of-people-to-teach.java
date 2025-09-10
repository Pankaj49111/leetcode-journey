class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length; // number of users
        // Store known languages for each user in a set for O(1) lookup
        Set<Integer>[] known = new HashSet[m + 1];
        for (int i = 1; i <= m; i++) {
            known[i] = new HashSet<>();
            for (int lang : languages[i - 1]) {
                known[i].add(lang);
            }
        }

        // Step 1: Find problematic users
        Set<Integer> problematic = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0], v = f[1];
            boolean canCommunicate = false;
            for (int lang : known[u]) {
                if (known[v].contains(lang)) {
                    canCommunicate = true;
                    break;
                }
            }
            if (!canCommunicate) {
                problematic.add(u);
                problematic.add(v);
            }
        }

        // Step 2: Try teaching each language and count how many users need it
        int ans = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int user : problematic) {
                if (!known[user].contains(lang)) {
                    count++;
                }
            }
            ans = Math.min(ans, count);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
