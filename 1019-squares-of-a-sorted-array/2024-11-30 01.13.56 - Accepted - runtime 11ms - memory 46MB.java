class Solution {
    public int[] sortedSquares(int[] nums) {
        return Arrays.stream(nums)
                    .map(a -> a*a)
                    .sorted()
                    .toArray();
    }
}