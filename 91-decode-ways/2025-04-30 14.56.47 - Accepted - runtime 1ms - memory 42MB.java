class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s == null || n == 0 || s.charAt(0) == '0') return 0;
        
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i=2; i<=n; i++){
            if(s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }

            int next = Integer.parseInt(s.substring(i-2, i));
            if(next >= 10 && next <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}