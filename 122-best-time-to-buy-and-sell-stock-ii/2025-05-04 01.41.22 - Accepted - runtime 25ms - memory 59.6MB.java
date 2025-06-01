class Solution {
    public int maxProfit(int[] prices) {
        Map<String, Integer> res = new HashMap<>();
        return dp(res, prices, 0, false);
    }

    int dp(Map<String, Integer> memo, int[] prices, int i, boolean hold) {
        if(i == prices.length) return 0;

        String key = i+"-"+(hold ? 1 : 0);

        if(memo.containsKey(key)) return memo.get(key);
        int result;
        if(hold){
            int sell = prices[i] + dp(memo, prices, i+1, false);
            int keep = dp(memo, prices, i+1, true);
            result = Math.max(sell, keep);
        } else {
            int buy = -prices[i] + dp(memo, prices, i+1, true);
            int skip = dp(memo, prices, i+1, false);
            result = Math.max(buy, skip);
        }

        memo.put(key, result);
        return result;
    }
}