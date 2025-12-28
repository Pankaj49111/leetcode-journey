class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int[] g: grid){
            int n = g.length;
            int l=0, r=n-1;
            int neg = n;

            while(l <= r) {
                int mid = l + (r-l)/2;
                if(g[mid] < 0){
                    neg = mid;
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            }
            count += n - neg;
        }
        return count;
    }
}