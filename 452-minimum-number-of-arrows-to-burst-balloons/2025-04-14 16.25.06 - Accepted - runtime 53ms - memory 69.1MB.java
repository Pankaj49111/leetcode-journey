class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));

        int[] f = points[0];
        int count = 1; // atleast 1 arraow
        int n = points.length;

        for(int i=1; i<points.length;){
            int[] curr = points[i++];

            if(curr[0] > f[1]){
                count++;
                f = curr;
            }
        }

        return count;
    }
}