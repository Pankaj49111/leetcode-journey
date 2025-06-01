class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int closest = Integer.MAX_VALUE;
        for(int i=0; i<n-2; i++){

            int j=i+1, k=n-1;
            while(j<k){
                int total = nums[i] + nums[j] + nums[k];
                if(Math.abs(total-target) < Math.abs(closest-target)){
                    closest = total;
                }
                
                if(total < target){
                    j++;
                } else if(total > target){
                    k--;
                } else {
                    return total;
                }
            }
        }
        return closest;
    }
}