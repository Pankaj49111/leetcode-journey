class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n=nums.length;
        int l = 0, h = nums[n-1] - nums[0];
        while(l<h){
            int mid = (h+l)/2;
            if(canFormPairs(nums, p, mid)){
                h = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }

    boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                count++;
                i++;
            }
        }
        return count >= p;
    }

}