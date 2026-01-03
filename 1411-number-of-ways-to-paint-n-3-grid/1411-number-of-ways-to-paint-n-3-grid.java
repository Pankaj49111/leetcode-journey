class Solution {
    static final int MOD = 1_000_000_007;

    public int numOfWays(int n) {
        long aba = 6; // patterns like A B A
        long abc = 6; // patterns like A B C

        for (int i = 2; i <= n; i++) {
            long newABA = (aba * 3 + abc * 2) % MOD;
            long newABC = (aba * 2 + abc * 2) % MOD;
            aba = newABA;
            abc = newABC;
        }

        return (int) ((aba + abc) % MOD);
    }
}
