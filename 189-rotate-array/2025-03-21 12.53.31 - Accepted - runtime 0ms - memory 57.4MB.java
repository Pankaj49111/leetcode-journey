class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length-1;
        k %= n+1;
        
        reverse(nums, n-k+1, n);
        reverse(nums, 0, n-k);
        reverse(nums, 0, n);
    }

    void reverse(int[] nums, int i, int j){
        while(i<j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;

            i++; j--;
        }
    }
}