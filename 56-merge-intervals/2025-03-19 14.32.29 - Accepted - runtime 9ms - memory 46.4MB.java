class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int[] f = intervals[0];
        List<int[]> ls = new ArrayList<>();

        int len = intervals.length;
        for(int i=1; i<len; i++){
            int[] curr = intervals[i];
            if(f[1] >= curr[0]){
                f[1] = Math.max(f[1], curr[1]);
            } else {
                ls.add(f);
                f = curr;
            }
        }
        ls.add(f);

        int[][] res = new int[ls.size()][2];
        for(int i=0; i<ls.size(); i++){
            res[i] = ls.get(i);
        }
        return res;
    }
}