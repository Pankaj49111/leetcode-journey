class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;

        int min = nums[0];
        if(min < k) return -1;

        int count=0;
        for(int i=0; i<n; i++){
            if(nums[i] > k){
                count++;

                while(i+1 < n && nums[i] == nums[i+1]) i++;
            }
        }
        return count;
    }
}