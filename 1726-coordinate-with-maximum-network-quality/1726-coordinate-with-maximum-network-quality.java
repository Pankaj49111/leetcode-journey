class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int maxQuality = 0;
        int[] best = new int[2];

        // Step 1: Define bounding box (min and max x, y)
        int maxX = 0, maxY = 0;
        for (int[] tower : towers) {
            maxX = Math.max(maxX, tower[0]);
            maxY = Math.max(maxY, tower[1]);
        }

        // Step 2: Evaluate all integer coordinates in the bounding box
        for (int x = 0; x <= maxX + radius; x++) {
            for (int y = 0; y <= maxY + radius; y++) {
                int quality = 0;

                for (int[] tower : towers) {
                    int dx = tower[0] - x;
                    int dy = tower[1] - y;
                    double distance = Math.sqrt(dx * dx + dy * dy);

                    if (distance <= radius) {
                        quality += (int) Math.floor(tower[2] / (1 + distance));
                    }
                }

                // Step 3: Update result if higher quality found or tie with lex smaller
                if (quality > maxQuality || (quality == maxQuality && (x < best[0] || (x == best[0] && y < best[1])))) {
                    maxQuality = quality;
                    best[0] = x;
                    best[1] = y;
                }
            }
        }

        return best;
    }
}
