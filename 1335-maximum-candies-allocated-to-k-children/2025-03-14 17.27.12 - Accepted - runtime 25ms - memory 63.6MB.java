class Solution {

    public int maximumCandies(int[] candies, long k) {
        int maxCandiesInPile = 0;
        for (int candy: candies) {
            maxCandiesInPile = Math.max(maxCandiesInPile, candy);
        }

        int left = 0;
        int right = maxCandiesInPile; // 8

        while (left < right) {
            int middle = (left + right + 1) / 2; //4

            if (canAllocateCandies(candies, k, middle)) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    private boolean canAllocateCandies(int[] candies, long k, int numOfCandies) {
        long maxNumOfChildren = 0;

        for (int candy: candies) {
            maxNumOfChildren += candy / numOfCandies;
        }
        return maxNumOfChildren >= k;
    }
}