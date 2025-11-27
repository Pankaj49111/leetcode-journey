class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // holds prices

        for (int i = n - 1; i >= 0; i--) {
            int price = prices[i];

            // Pop all elements > current price
            while (!stack.isEmpty() && stack.peek() > price) {
                stack.pop();
            }

            int discount = stack.isEmpty() ? 0 : stack.peek();
            ans[i] = price - discount;

            stack.push(price);
        }

        return ans;
    }
}
