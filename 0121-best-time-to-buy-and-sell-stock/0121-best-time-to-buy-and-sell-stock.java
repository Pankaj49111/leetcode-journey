class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if (n == 0) return 0;

        int[] minPre = new int[n];
        int[] maxPost = new int[n];

        minPre[0] = prices[0];
        for (int i = 1; i < n; i++) {
            minPre[i] = Math.min(minPre[i - 1], prices[i]);
        }

        maxPost[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPost[i] = Math.max(maxPost[i + 1], prices[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, maxPost[i] - minPre[i]);
        }

        return res;
    }

}