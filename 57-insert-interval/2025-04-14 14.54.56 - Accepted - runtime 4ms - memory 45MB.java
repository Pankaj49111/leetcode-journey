class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        List<int[]> ls = new ArrayList<>(Arrays.asList(intervals));
        ls.add(newInterval);
        ls.sort(Comparator.comparingInt(a -> a[0]));

        int[] f = ls.get(0);
        for(int i = 1; i < ls.size(); i++){
            int[] curr = ls.get(i);
            if(curr[0] <= f[1]){
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