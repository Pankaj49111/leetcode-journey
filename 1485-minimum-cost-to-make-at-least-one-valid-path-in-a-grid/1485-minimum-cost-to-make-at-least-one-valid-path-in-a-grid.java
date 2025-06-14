class Solution {
    public int minCost(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int[][] costs = new int[r][c];
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int[] cs: costs){
            Arrays.fill(cs, Integer.MAX_VALUE);
        }
        costs[0][0] = 0;
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        pq.offer(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currCost = curr[0], x = curr[1], y = curr[2];

            if(x == r-1 && y == c-1) return currCost;

            for(int d = 0; d < dirs.length; d++){
                int nx = dirs[d][0]+x, ny = dirs[d][1]+y;

                if(nx >= 0 && ny >= 0 && nx < r && ny < c){
                    int expDir = grid[x][y] - 1;
                    int newCost = currCost + (d == expDir ? 0 : 1);

                    if(newCost < costs[nx][ny]){
                        costs[nx][ny] = newCost;
                        pq.offer(new int[]{newCost, nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}