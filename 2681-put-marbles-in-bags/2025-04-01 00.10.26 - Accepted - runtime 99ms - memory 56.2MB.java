class Solution {
    public long putMarbles(int[] weights, int k) {
        if(k == 1 || k == weights.length) return 0;

        List<Integer> pairSum = new ArrayList<>();
        for(int i=0; i<weights.length-1; i++){
            pairSum.add(weights[i] + weights[i+1]);
        }

        Collections.sort(pairSum);

        long minScore=0, maxScore = 0;
        for(int i=0; i<k-1; i++){
            minScore += pairSum.get(i);
            maxScore += pairSum.get(pairSum.size()-1-i);
        }
        return maxScore - minScore;
    }
}