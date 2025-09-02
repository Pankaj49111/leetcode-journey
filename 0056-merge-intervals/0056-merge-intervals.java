class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        int[] f = intervals[0];
        for(int i=1; i<intervals.length; i++){
            int[] curr = intervals[i];
            if(f[1] >= curr[0]){
                f[1] = Math.max(f[1], curr[1]);
            } else {
                res.add(f);
                f = curr;
            }
        }
        res.add(f);
        return res.toArray(new int[res.size()][]);
    }
}