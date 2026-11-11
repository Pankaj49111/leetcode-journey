class Solution {
    public int maxScore(int[] cp, int k) {
        int n = cp.length;
        int sum=0;

        for(int i=0; i<k; i++){
            sum += cp[i];
        }

        int maxSum = sum;

        for(int i=0; i<k; i++){

            sum -= cp[k-1-i];
            sum += cp[n-1-i];

            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}