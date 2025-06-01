class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        
        List<int[]> mergedMeetings = new ArrayList<>();
        for (int[] meeting : meetings) {
            if (mergedMeetings.isEmpty() || mergedMeetings.get(mergedMeetings.size() - 1)[1] < meeting[0]) {
                mergedMeetings.add(meeting);
            } else {
                mergedMeetings.get(mergedMeetings.size() - 1)[1] = Math.max(mergedMeetings.get(mergedMeetings.size() - 1)[1], meeting[1]);
            }
        }
        
        int freeDays = 0;
        
        // Before the first meeting
        if (mergedMeetings.get(0)[0] > 1) {
            freeDays += mergedMeetings.get(0)[0] - 1;
        }
        
        // Between the meetings
        for (int i = 1; i < mergedMeetings.size(); i++) {
            freeDays += mergedMeetings.get(i)[0] - mergedMeetings.get(i - 1)[1] - 1;
        }
        
        // After the last meeting
        if (mergedMeetings.get(mergedMeetings.size() - 1)[1] < days) {
            freeDays += days - mergedMeetings.get(mergedMeetings.size() - 1)[1];
        }
        
        return freeDays;
    }
}
