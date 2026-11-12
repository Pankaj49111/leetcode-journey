class Solution {
    public int trap(int[] height) {
        int l=0, r=height.length-1, lmax=0, rmax=0, sum=0;

        while(l<=r){
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            if(lmax <= rmax){
                sum += lmax - height[l++];
            } else {
                sum += rmax - height[r--];
            }
        }
        return sum;
    }
}