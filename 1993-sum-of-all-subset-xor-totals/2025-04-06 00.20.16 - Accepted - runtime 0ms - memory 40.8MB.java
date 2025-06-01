class Solution {
    public int subsetXORSum(int[] nums) {
        return XORSums(nums, 0, 0);
    }
    int XORSums(int[] nums, int idx, int xorSum){
        if(idx == nums.length) return xorSum;

        int withElement = XORSums(nums, idx+1, xorSum ^ nums[idx]);
        int withoutElement = XORSums(nums, idx+1, xorSum);

        return withElement + withoutElement;
    }
}