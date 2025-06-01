class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i=0; i<n; i++){
            dp[i][i] = true;
            count++;
        }

        for(int length=2; length<=n; length++){
            for(int i=0; i<= n-length; i++){
                int j = i + length - 1;

                if(s.charAt(i) == s.charAt(j)){
                    if(length == 2 || dp[i+1][j-1]){
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}