class Solution {
    static final int mod = 1000000007;

    public int colorTheGrid(int m, int n) {
        // Step 1: Generate all valid colorings for a single row.
        List<List<Integer>> valid = new ArrayList<>();
        
        // Enumerate all valid row colorings, where each element in row is between 0, 1, 2 (colors)
        generateValidRows(m, valid);
        
        // Step 2: Create a map to track valid row-to-row transitions (adjacency condition)
        Map<List<Integer>, List<List<Integer>>> adjacent = new HashMap<>();
        for (List<Integer> row1 : valid) {
            for (List<Integer> row2 : valid) {
                if (isValidTransition(row1, row2)) {
                    adjacent.computeIfAbsent(row1, k -> new ArrayList<>()).add(row2);
                }
            }
        }

        // Step 3: Initialize DP table to count valid configurations of rows
        Map<List<Integer>, Integer> f = new HashMap<>();
        for (List<Integer> row : valid) {
            f.put(row, 1);  // There's one way to color the first column with any valid row
        }

        // Step 4: Iterate over columns and update the DP table
        for (int i = 1; i < n; ++i) {
            Map<List<Integer>, Integer> g = new HashMap<>();
            for (List<Integer> row2 : valid) {
                for (List<Integer> row1 : adjacent.getOrDefault(row2, new ArrayList<>())) {
                    g.put(row2, (g.getOrDefault(row2, 0) + f.getOrDefault(row1, 0)) % mod);
                }
            }
            f = g;
        }

        // Step 5: Sum the results for all valid configurations in the last column
        int ans = 0;
        for (int num : f.values()) {
            ans = (ans + num) % mod;
        }
        return ans;
    }

    // Step 1 Helper: Generate all valid row colorings
    private void generateValidRows(int m, List<List<Integer>> valid) {
        int max = (int) Math.pow(3, m);  // 3^m different ways to color the row
        for (int mask = 0; mask < max; ++mask) {
            List<Integer> row = new ArrayList<>();
            int temp = mask;
            for (int i = 0; i < m; ++i) {
                row.add(temp % 3);
                temp /= 3;
            }
            if (isValidRow(row)) {
                valid.add(row);
            }
        }
    }

    // Step 1 Helper: Check if a row is valid (no two adjacent cells have the same color)
    private boolean isValidRow(List<Integer> row) {
        for (int i = 0; i < row.size() - 1; ++i) {
            if (row.get(i).equals(row.get(i + 1))) {
                return false;
            }
        }
        return true;
    }

    // Step 2 Helper: Check if two rows can be placed adjacent to each other (no same colors in the same column)
    private boolean isValidTransition(List<Integer> row1, List<Integer> row2) {
        for (int i = 0; i < row1.size(); ++i) {
            if (row1.get(i).equals(row2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
