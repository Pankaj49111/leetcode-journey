class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] lc = new int[n];
        int[] rc = new int[n];
        Arrays.fill(lc, 1);
        Arrays.fill(rc, 1);

        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                lc[i] = lc[i-1]+1;
            }
        }
        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                rc[i] = rc[i+1]+1;
            }
        }

        int totalCandies = 0;
        for (int i=0; i<n; i++) {
            totalCandies += Math.max(lc[i], rc[i]);
        }

        return totalCandies;
    }
}