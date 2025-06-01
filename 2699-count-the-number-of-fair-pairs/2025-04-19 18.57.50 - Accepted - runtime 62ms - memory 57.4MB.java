class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n=nums.length;
        long count=0;

        for(int i=0; i<n; i++){
            int l = i+1, r = n-1;

            while(l<=r){
                int mid = l + (r-l)/2;
                if(nums[i] + nums[mid] < lower){
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }
            int start = l;

            l = i+1; r = n-1;
            while(l<=r){
                int mid = l+(r-l)/2;
                if(nums[i]+nums[mid] > upper){
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            }
            int end = r;

            if(start <= end) count += end - start + 1;
        }
        return count;
    }
}