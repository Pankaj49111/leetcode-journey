class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        Integer[][][] dp =
            new Integer[n][3][2];

        return solve(prices, 0, 2, 0, dp);
    }

    private int solve(
            int[] prices,
            int day,
            int transactionsLeft,
            int holding,
            Integer[][][] dp) {

        if (day == prices.length || transactionsLeft == 0) {
            return 0;
        }

        if (dp[day][transactionsLeft][holding] != null) {
            return dp[day][transactionsLeft][holding];
        }

        int result;

        if (holding == 0) {

            int skip = solve(
                prices,
                day + 1,
                transactionsLeft,
                0,
                dp
            );

            int buy = -prices[day]
                    + solve(
                        prices,
                        day + 1,
                        transactionsLeft,
                        1,
                        dp
                    );

            result = Math.max(skip, buy);

        } else {

            int skip = solve(
                prices,
                day + 1,
                transactionsLeft,
                1,
                dp
            );

            int sell = prices[day]
                    + solve(
                        prices,
                        day + 1,
                        transactionsLeft - 1,
                        0,
                        dp
                    );

            result = Math.max(skip, sell);
        }

        dp[day][transactionsLeft][holding] = result;
        return result;
    }
}