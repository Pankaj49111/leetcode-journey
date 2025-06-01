class Solution {
    int min = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
        dfs(start, end, geneBank, 0, new HashSet<>());
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    void dfs(String curr, String end, Set<String> bank, int steps, Set<String> visited) {
        if (curr.equals(end)) {
            min = Math.min(min, steps);
            return;
        }

        for (String gene : bank) {
            if (!visited.contains(gene) && isOneMutation(curr, gene)) {
                visited.add(gene);
                dfs(gene, end, bank, steps + 1, visited);
                visited.remove(gene);
            }
        }
    }

    boolean isOneMutation(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i)) diff++;
        return diff == 1;
    }
}
