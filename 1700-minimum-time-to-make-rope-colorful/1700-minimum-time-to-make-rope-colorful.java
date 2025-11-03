class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        int n = colors.length();
        
        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // Remove the smaller one
                totalTime += Math.min(neededTime[i], neededTime[i - 1]);
                
                // Keep the higher time for future comparison
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }
        
        return totalTime;
    }
}
