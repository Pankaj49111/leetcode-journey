class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0, n = points.length;

        for(int i=1; i<n; i++){
            int x = points[i-1][0];
            int y = points[i-1][1];
            int nx = points[i][0];
            int ny = points[i][1];

            while(x!=nx || y!=ny){
                if(x<nx) x++;
                else if(x>nx) x--;

                if(y<ny) y++;
                else if(y>ny) y--;

                time++;
            }
        }
        return time;
    }
}