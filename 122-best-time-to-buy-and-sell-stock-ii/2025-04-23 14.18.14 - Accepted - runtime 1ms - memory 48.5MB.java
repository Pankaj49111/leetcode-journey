class Solution {
    public int[] trade( int day, int[] prices ){
        if( day == 0){
            int[] res = { -prices[0], 0 };
            return res;
        }

        int[] prev = trade(day-1, prices);
        int prevHold = prev[0], prevNotHold = prev[1];

        int hold = Math.max(prevHold, prevNotHold - prices[day]);
        int notHold =  Math.max(prevNotHold, prevHold + prices[day]);

        int[] res = {hold, notHold};
        return res;
    }
    
    public int maxProfit(int[] prices){
        int[] res = trade(prices.length - 1, prices);
        return res[1];
    }
}
