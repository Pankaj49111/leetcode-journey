class Solution {
    public int maxArea(int[] height) {
        int maxAr = 0, i = 0, j = height.length-1;

        while(i<j){
            int minHeight = Math.min(height[i], height[j]);
            maxAr = Math.max(maxAr, minHeight*(j-i));

            while(i<j && height[i] <= minHeight) i++;
            while(i<j && height[j] <= minHeight) j--;
        }
        return maxAr;
    }
}