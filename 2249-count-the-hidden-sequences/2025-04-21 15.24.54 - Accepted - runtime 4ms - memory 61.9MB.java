class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int n = differences.length;
        long minPrefixSum = 0, maxPrefixSum = 0, currentSum = 0;
        
        for (int diff : differences) {
            currentSum += diff;
            minPrefixSum = Math.min(minPrefixSum, currentSum);
            maxPrefixSum = Math.max(maxPrefixSum, currentSum);
        }
        
        long minFirstElement = lower - minPrefixSum;
        long maxFirstElement = upper - maxPrefixSum;
        
        if (minFirstElement > maxFirstElement) {
            return 0;
        }

        return (int)Math.max(0, maxFirstElement - minFirstElement + 1);
    }
}
