import java.util.*;

class Solution {
    static class State {
        int row;
        int col;
        int energy;
        int mask;
        int moves;

        State(int row, int col, int energy, int mask, int moves) {
            this.row = row;
            this.col = col;
            this.energy = energy;
            this.mask = mask;
            this.moves = moves;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int startRow = 0;
        int startCol = 0;

        // litterId[r][c] tells us which litter this cell represents.
        // -1 means this cell is not litter.
        int[][] litterId = new int[m][n];

        int litterCount = 0;

        // Find S and give every L an ID.
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                litterId[r][c] = -1;

                char ch = classroom[r].charAt(c);
                if (ch == 'S') {
                    startRow = r;
                    startCol = c;
                }

                if (ch == 'L') {
                    litterId[r][c] = litterCount;
                    litterCount++;
                }
            }
        }

        // No litter to collect.
        if (litterCount == 0) {
            return 0;
        }

        /*
         * If there are K litter pieces:
         *
         * possible masks = 2^K
         *
         * Example:
         * K = 3
         * masks = 000, 001, 010, 011,
         *         100, 101, 110, 111
         *
         * 1 << K = 2^K
         */
        int totalMasks = 1 << litterCount;

        /*
         * visited[row][col][energy][mask]
         *
         * means:
         * "Have we already visited this exact state?"
         */
        boolean[][][][] visited =
                new boolean[m][n][energy + 1][totalMasks];

        Queue<State> queue = new ArrayDeque<>();

        // Initially, nothing is collected.
        int startMask = 0;

        queue.offer(
                new State(
                        startRow,
                        startCol,
                        energy,
                        startMask,
                        0
                )
        );

        visited[startRow][startCol][energy][startMask] = true;

        // Up, down, left, right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            State current = queue.poll();

            // Have we collected all litter?
            int finalMask = totalMasks - 1;

            if (current.mask == finalMask) {
                return current.moves;
            }

            // Try all 4 directions.
            for (int d = 0; d < 4; d++) {

                int nr = current.row + dr[d];
                int nc = current.col + dc[d];

                // Outside grid
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                // Can't walk through X
                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                // Moving costs 1 energy.
                int newEnergy = current.energy - 1;

                // No energy to make this move.
                if (newEnergy < 0) {
                    continue;
                }

                // R resets energy back to maximum.
                if (classroom[nr].charAt(nc) == 'R') {
                    newEnergy = energy;
                }

                /*
                 * Initially, we have collected exactly the same
                 * litter as the current state.
                 */
                int newMask = current.mask;

                // Did we move onto litter?
                if (classroom[nr].charAt(nc) == 'L') {

                    int id = litterId[nr][nc];

                    /*
                     * Turn ON the bit representing this litter.
                     *
                     * 1 << id
                     *
                     * creates a number with only that bit ON.
                     *
                     * OR (|) adds it to our mask.
                     */
                    newMask = current.mask | (1 << id);
                }

                /*
                 * Have we already seen this exact:
                 *
                 * position + energy + collected litter
                 */
                if (visited[nr][nc][newEnergy][newMask]) {
                    continue;
                }

                visited[nr][nc][newEnergy][newMask] = true;

                queue.offer(
                        new State(
                                nr,
                                nc,
                                newEnergy,
                                newMask,
                                current.moves + 1
                        )
                );
            }
        }

        // BFS finished without collecting everything.
        return -1;
    }
}
