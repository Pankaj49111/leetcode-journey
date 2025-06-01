class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for(int num : nums){
            int rem = num%3;
            if(rem == 1 || rem == 2) count++;
        }
        return count;
    }
}