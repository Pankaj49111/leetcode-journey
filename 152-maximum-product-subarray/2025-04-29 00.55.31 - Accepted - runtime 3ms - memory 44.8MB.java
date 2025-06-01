public class Solution {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] maxDP = new int[n];
        int[] minDP = new int[n];

        maxDP[0] = minDP[0] = nums[0];
        int maxProd = nums[0];

        for(int i=1; i<n; i++){
            int num = nums[i];

            maxDP[i] = Math.max(num, Math.max(maxDP[i-1]*num, minDP[i-1]*num));
            minDP[i] = Math.min(num, Math.min(maxDP[i-1]*num, minDP[i-1]*num));

            maxProd = Math.max(maxProd, maxDP[i]);
        }
        return maxProd;
    }
}
