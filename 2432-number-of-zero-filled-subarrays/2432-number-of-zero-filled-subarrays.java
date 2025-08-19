class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count=0;
        long consec = 0;

        for(int num : nums){
            if(num == 0) {
                consec++;
            } else {
                count += (consec*(consec+1))/2;
                consec = 0;
            }
        }
        count += (consec*(consec+1))/2;
        return count;
    }
}