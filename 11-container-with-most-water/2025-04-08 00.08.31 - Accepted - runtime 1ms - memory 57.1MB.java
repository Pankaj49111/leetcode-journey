class Solution {
    public int maxArea(int[] height) {
        int i=0, j=height.length-1;
        int maxArea = 0;

        while(i<j){
            int minHt = Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, minHt * (j-i));

            while(i<j && height[i] <= minHt) i++;
            while(i<j && height[j] <= minHt) j--;
        }
        return maxArea;
    }
}