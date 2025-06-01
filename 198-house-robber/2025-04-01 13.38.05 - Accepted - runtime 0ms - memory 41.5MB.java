class Solution {
    public int rob(int[] nums) {
        int prevRob = 0, maxRob = 0;
        for(int num: nums){
            int tmp = Math.max(maxRob, prevRob + num);
            prevRob = maxRob;
            maxRob = tmp;
        }
        return maxRob;
    }
}