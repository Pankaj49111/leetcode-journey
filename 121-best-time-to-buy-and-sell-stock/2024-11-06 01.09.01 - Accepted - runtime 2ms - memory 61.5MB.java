class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = Integer.MIN_VALUE;

        for(int price: prices){
            minPrice = Math.min(minPrice, price);
            maxPrice = Math.max(maxPrice, price - minPrice);
        }
        return maxPrice;
    }
}