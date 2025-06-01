import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        
        int count = 0;
        
        int mergedStart = meetings[0][0];
        int mergedEnd = meetings[0][1];
        
        // Count before the first meeting
        if (mergedStart > 1) count += mergedStart - 1;
        
        
        for (int i = 1; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            
            // If there's no overlap, count the free days between the current meeting and the last merged meeting
            if (start > mergedEnd) {
                count += start - mergedEnd - 1;
                mergedStart = start;
                mergedEnd = end;
            } else {
                // If there is an overlap, merge the meetings by extending the merged end time
                mergedEnd = Math.max(mergedEnd, end);
            }
        }
        
        // Count free days after the last meeting
        if (mergedEnd < days) {
            count += days - mergedEnd;
        }
        
        return count;
    }
}
