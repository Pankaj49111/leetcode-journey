class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        int n=candies.length;
        for(int i=0; i<n; i++){
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        List<Boolean> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            if (candies[i] + extraCandies >= max){
                result.add(true);
            }
            else {
                result.add(false);
            }
        }
        return result;
    }
}