class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int n = nums.length;
        int[][] intervals = new int[n][2];

        for(int i=0; i<n; i++){
            intervals[i][0] = nums[i]-k;
            intervals[i][1] = nums[i]+k;
        }

        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);

        int count=0, curr = Integer.MIN_VALUE;

        for(int[] range: intervals){
            int l=range[0], r=range[1];
            curr = Math.max(curr, l);

            if(curr <= r){
                count++; curr++;
            }
        }
        return count;
    }
}