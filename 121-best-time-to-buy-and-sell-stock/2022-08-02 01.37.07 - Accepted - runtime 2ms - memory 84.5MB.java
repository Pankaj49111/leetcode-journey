class Solution {
    public int maxProfit(int[] prices) {
        int minBuy=Integer.MAX_VALUE, maxSell=Integer.MIN_VALUE;
        int diff=0;
        for(int i=0; i<prices.length; i++) {
            if(minBuy>prices[i]){
                minBuy = prices[i];
                maxSell = 0;
            }
            if(maxSell<prices[i]) {
                maxSell = prices[i];
                diff = Math.max(diff, (maxSell-minBuy));
            }
        }
        return (diff > 0)?diff:0;
    }
}