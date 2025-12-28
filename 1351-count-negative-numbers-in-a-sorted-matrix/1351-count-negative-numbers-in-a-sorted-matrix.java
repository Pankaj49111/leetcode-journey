class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int[] g: grid){
            int n = g.length;
            for(int i=n-1; i>=0; i--){
                if(g[i] < 0) count++;
                else break;
            }
        }
        return count;
    }
}