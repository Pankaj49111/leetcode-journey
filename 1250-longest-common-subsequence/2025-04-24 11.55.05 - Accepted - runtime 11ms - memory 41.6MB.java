class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int[] dp = new int[n];
        int longest = 0;

        for(char c : text2.toCharArray()){
            int currLen = 0;
            for(int i=0; i<dp.length; i++){
                if(currLen < dp[i]){
                    currLen = dp[i];
                } else if(c == text1.charAt(i)){
                    dp[i] = currLen + 1;
                    longest = Math.max(longest, currLen + 1);
                }
            }
        }
        return longest;
    }
}