class Solution {
    public String rankTeams(String[] votes) {
        if (votes == null || votes.length == 0) return "";

        int k = votes[0].length();
        // Map each team char to its counts array
        Map<Character, int[]> counts = new HashMap<>();
        for (char c : votes[0].toCharArray()) {
            counts.put(c, new int[k]);
        }

        // Fill counts: for each vote string, increment the appropriate position count
        for (String vote : votes) {
            for (int pos = 0; pos < k; pos++) {
                char team = vote.charAt(pos);
                counts.get(team)[pos]++;
            }
        }

        // Create team list and sort with custom comparator
        List<Character> teams = new ArrayList<>(counts.keySet());
        teams.sort((a, b) -> {
            int[] ca = counts.get(a);
            int[] cb = counts.get(b);
            for (int i = 0; i < k; i++) {
                if (ca[i] != cb[i]) return cb[i] - ca[i]; // more votes at earlier pos wins
            }
            return a - b; // tie-break by alphabet
        });

        // Build result
        StringBuilder sb = new StringBuilder();
        for (char c : teams) sb.append(c);
        return sb.toString();
    }
}
