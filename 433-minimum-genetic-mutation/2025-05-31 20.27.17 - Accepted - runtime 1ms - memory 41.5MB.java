public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
        if (!geneBank.contains(end)) return -1;

        char[] chars = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                if (curr.equals(end)) return level;

                char[] currArr = curr.toCharArray();
                for (int i = 0; i < currArr.length; i++) {
                    char old = currArr[i];
                    for (char c : chars) {
                        if (c == old) continue;
                        currArr[i] = c;
                        String next = new String(currArr);
                        if (geneBank.contains(next) && !visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                    currArr[i] = old;
                }
            }
            level++;
        }

        return -1;
    }
}
