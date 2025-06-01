class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);
        int cnt=0;

        Arrays.stream(intervals).flatMapToInt(Arrays::stream)
        .forEach(s -> System.out.print(s + ", "));

        int[] f = intervals[0];
        int n=intervals.length;
        for(int i=1; i < n; i++){
            int[] curr = intervals[i];
            if(f[1] <= curr[0] && f[1] < curr[1]) {
                f = curr;
            } else {
                cnt++;
            }
        }
        return cnt;
    }
}