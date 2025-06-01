class Solution {
    public long putMarbles(int[] weights, int k) {
        if(k == 1 || k == weights.length) return 0;

        int n = weights.length;
        int[] pairs = new int[n-1];

        for(int i=0; i<weights.length-1; i++){
            pairs[i] = (weights[i] + weights[i+1]);
        }

        Arrays.sort(pairs);

        long minScore=0, maxScore = 0;
        for(int i=0; i<k-1; i++){
            minScore += pairs[i];
        }

        for(int i=n-2; i>=n-k; i--){
            maxScore += pairs[i];
        }
        return maxScore - minScore;
    }
}