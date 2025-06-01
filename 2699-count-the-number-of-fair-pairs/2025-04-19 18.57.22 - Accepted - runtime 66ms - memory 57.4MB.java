class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n=nums.length;
        long count=0;

        for(int i=0; i<n; i++){
            int l = i+1, r = n-1;

            int start = lower(nums, l, r, lower - nums[i]);
            int end = upper(nums, l, r, upper - nums[i]);
            count += end - start + 1;
        }
        return count;
    }

    int lower(int[] nums, int l, int r, int target){
        int ans = r+1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] < target){
                l = mid+1;
            } else {
                ans = mid;
                r = mid-1;
            }
        }
        return ans;
    }
    int upper(int[] nums, int l, int r, int target){
        int ans = l-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid] > target){
                r = mid-1;
            } else {
                ans = mid;
                l = mid+1;
            }
        }
        return ans;
    }

}