class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        int n=candies.length;
        for(int i=0; i<n; i++){
            max = Math.max(max, candies[i]);
        }
        List<Boolean> result = new ArrayList<>();
        for(int i=0; i<candies.length; i++){
            result.add(candies[i] + extraCandies >= max);
        }
        return result;
    }
}