class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0, n = points.length;

        for(int i=1; i<n; i++){
            int x = points[i-1][0];
            int y = points[i-1][1];
            int nx = points[i][0];
            int ny = points[i][1];

            time += Math.max(Math.abs(x-nx), Math.abs(y-ny));
        }
        return time;
    }
}