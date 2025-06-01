class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        int minPrice = prices[0];
        int maxProfit = -1;
        for(int i=1; i<prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-minPrice);
        }
        return maxProfit;
    }
}