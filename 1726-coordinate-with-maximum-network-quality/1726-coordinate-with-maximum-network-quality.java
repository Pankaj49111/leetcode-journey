class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int maxX = 0, maxY = 0;
        for (int[] tower : towers) {
            maxX = Math.max(maxX, tower[0]);
            maxY = Math.max(maxY, tower[1]);
        }

        // Max-heap based on quality, then lex smallest (x, y)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[2] != a[2]) return Integer.compare(b[2], a[2]); // Higher quality first
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]); // Lower x first
            return Integer.compare(a[1], b[1]);                  // Lower y first
        });

        for (int x = 0; x <= maxX + radius; x++) {
            for (int y = 0; y <= maxY + radius; y++) {
                int totalQuality = 0;

                for (int[] tower : towers) {
                    int dx = tower[0] - x;
                    int dy = tower[1] - y;
                    double dist = Math.sqrt(dx * dx + dy * dy);
                    if (dist <= radius) {
                        totalQuality += (int) Math.floor(tower[2] / (1 + dist));
                    }
                }

                pq.offer(new int[]{x, y, totalQuality});
            }
        }

        int[] best = pq.peek(); // Top of the heap is the best coordinate
        return new int[]{best[0], best[1]};
    }
}