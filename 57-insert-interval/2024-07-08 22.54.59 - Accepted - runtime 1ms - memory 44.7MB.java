class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};

        List<int[]> list = new ArrayList<>();
        int i=0, n = intervals.length;
        
        // adding all elements less than 0th element of newInterval
        while(i<n && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }

        // updating newInterval
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);

        // adding remaining
        while(i<n) {
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }
}