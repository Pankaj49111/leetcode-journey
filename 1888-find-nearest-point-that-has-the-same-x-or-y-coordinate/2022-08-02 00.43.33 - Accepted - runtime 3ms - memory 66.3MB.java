class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int result=-1,r=points.length,dist=Integer.MAX_VALUE;
        
        for(int i=0; i<r; i++) {
            if(x==points[i][0]|| y==points[i][1]) {
                int newDist = (Math.abs(x-points[i][0]) + Math.abs(y-points[i][1]));
                if(dist>newDist) {
                    dist = newDist;
                    result=i;
                }
            }
        }
        return result;
    }
}