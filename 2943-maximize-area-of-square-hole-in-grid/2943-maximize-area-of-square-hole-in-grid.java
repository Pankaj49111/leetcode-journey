class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hB, int[] vB) {
        if(n == 1 || m == 1) return 4;
        Arrays.sort(hB);
        Arrays.sort(vB);

        int[] hE = findEnds(hB); 
        int[] vE = findEnds(vB);

        System.out.println(Arrays.toString(hE));
        System.out.println(Arrays.toString(vE));

        int side = Math.min(hE[1]-hE[0]+2, vE[1]-vE[0]+2);
        return side*side;
    }

    int[] findEnds(int[] bars){
        int bestEnd=bars[0]; int bestStart=bars[0];
        int currEnd=bars[0]; int currStart=bars[0];

        for(int i=1; i<bars.length; i++){
            if(bars[i] == bars[i-1]+1){
                currEnd = bars[i];
            } else {
                if(bestEnd - bestStart < currEnd - currStart){
                    bestStart = currStart;
                    bestEnd = currEnd;
                }
                currStart = bars[i];
                currEnd = bars[i];
            }
        }
        if(bestEnd - bestStart <= currEnd - currStart){
            bestStart = currStart;
            bestEnd = currEnd;
        }
        return new int[]{bestStart, bestEnd};
    }
}