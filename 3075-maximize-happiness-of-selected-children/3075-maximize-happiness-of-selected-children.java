class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        int n = happiness.length;
        long total = 0;
        int turns = 0;

        for (int i = n - 1; i >= 0 && k > turns; i--) {
            int current = happiness[i] - turns;
            if(current <= 0) break;
            
            total += current;
            turns++;
        }

        return total;
    }

}