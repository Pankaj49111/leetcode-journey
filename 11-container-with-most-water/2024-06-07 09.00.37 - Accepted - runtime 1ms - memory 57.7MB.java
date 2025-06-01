class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0, minHeight;

        while(l < r){
           minHeight = Math.min(height[l],height[r]);
           max = Math.max(max , minHeight * (r - l));

           while(l < r && height[l] <= minHeight) 
              l++;
           while(l < r && height[r] <= minHeight) 
              r--;
        }
        return max;
    }
}