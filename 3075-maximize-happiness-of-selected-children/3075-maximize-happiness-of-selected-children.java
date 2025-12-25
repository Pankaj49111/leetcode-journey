class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        int n = happiness.length;
        long total = 0;
        int decrement = 0;

        for (int i = n - 1; i >= 0 && k > 0; i--) {
            int current = happiness[i] - decrement;
            if (current > 0) {
                total += current;
                decrement++;
                k--;
            } else {
                break;
            }
        }

        return total;
    }

}