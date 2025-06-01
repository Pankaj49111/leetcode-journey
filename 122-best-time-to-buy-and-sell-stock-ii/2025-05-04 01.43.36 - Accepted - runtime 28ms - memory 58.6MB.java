class Solution {
    Map<String, Integer> memo = new HashMap<>();
    public int maxProfit(int[] prices) {
        return dp(prices, 0, false);
    }

    int dp(int[] prices, int i, boolean hold) {
        if(i == prices.length) return 0;

        String key = i+"-"+(hold ? 1 : 0);

        if(memo.containsKey(key)) return memo.get(key);
        int result;
        if(hold){
            int sell = dp(prices, i+1, false) + prices[i];
            int keep = dp(prices, i+1, true);
            result = Math.max(sell, keep);
        } else {
            int buy = dp(prices, i+1, true) - prices[i];
            int skip = dp(prices, i+1, false);
            result = Math.max(buy, skip);
        }

        memo.put(key, result);
        return result;
    }
}