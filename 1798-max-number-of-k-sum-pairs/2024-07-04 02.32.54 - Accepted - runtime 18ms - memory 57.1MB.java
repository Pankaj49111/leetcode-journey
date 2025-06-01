class Solution {
    public int maxOperations(int[] nums, int k) {
        int count=0;
        Arrays.sort(nums);
        int i=0, j=nums.length-1;
        while(i<j){
            // while(nums[j] > k && j != 0){ j--; }
            if(i<j && nums[i] + nums[j] == k){
                i++;
                j--;
                count++;
            } else if(nums[i] + nums[j] > k){
                j--;
            } else {
                i++;
            }
        }
        return count;
    }
}