class Solution {
    public int maxProfit(int k, int[] prices) {
        Map<String, Integer> res = new HashMap<>();
        return dp(res, prices, 0, k, false);
    }

    int dp(Map<String, Integer> memo, int[] prices, int i, int k, boolean hold) {
        if(k == 0 || i == prices.length) return 0;

        String key = i+"-"+k+"-"+(hold ? 1 : 0);

        if(memo.containsKey(key)) return memo.get(key);
        int result;
        if(hold){
            int sell = prices[i] + dp(memo, prices, i+1, k-1, false);
            int keep = dp(memo, prices, i+1, k, true);
            result = Math.max(sell, keep);
        } else {
            int buy = -prices[i] + dp(memo, prices, i+1, k, true);
            int skip = dp(memo, prices, i+1, k, false);
            result = Math.max(buy, skip);
        }

        memo.put(key, result);
        return result;
    }
}