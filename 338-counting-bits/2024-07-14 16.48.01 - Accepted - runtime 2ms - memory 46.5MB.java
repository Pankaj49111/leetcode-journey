class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        int offset = 1;
        for(int idx=1; idx<n+1; ++idx){
            if(offset*2 == idx) {
                offset *= 2;
            }
            res[idx] = res[idx - offset] + 1;
        }
        return res;
    }
}