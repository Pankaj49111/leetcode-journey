class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] xIntervals = new int[rectangles.length][2];
        int[][] yIntervals = new int[rectangles.length][2];

        for(int i=0; i<rectangles.length; i++){
            xIntervals[i][0] = rectangles[i][0];
            xIntervals[i][1] = rectangles[i][2];
            yIntervals[i][0] = rectangles[i][1];
            yIntervals[i][1] = rectangles[i][3];
        }

        return check(xIntervals) || check(yIntervals);
    }

    boolean check(int[][] intervals){
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int f = intervals[0][1];

        for(int[] interval: intervals){
            if(f <= interval[0]){
                count++;
            }
            f = Math.max(f, interval[1]);
        }
        return count >= 2;
    }
}