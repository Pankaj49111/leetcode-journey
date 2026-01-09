class Solution {
    public int stoneGameVI(int[] av, int[] bv) {
        int n = av.length;
        Integer[] idx = new Integer[n];

        for(int i=0; i<n; i++) idx[i] = i;

        Arrays.sort(idx, (i,j) -> (av[j]+bv[j]) - (av[i]+bv[i]));

        int aScore=0, bScore=0;

        for(int turn=0; turn<n; turn++){
            int stone = idx[turn];
            if(turn%2 == 0){
                aScore += av[stone];
            } else {
                bScore += bv[stone];
            }
        }
        if (aScore > bScore) return 1;
        if (aScore < bScore) return -1;
        return 0;
    }
}
