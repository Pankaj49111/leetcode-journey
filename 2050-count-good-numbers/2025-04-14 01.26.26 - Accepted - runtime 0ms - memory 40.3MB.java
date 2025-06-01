class Solution {
    final long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = (n)/2;

        long evenPow = helper(5, even);
        long oddPow = helper(4, odd);

        return (int)((evenPow*oddPow) % MOD);
    }

    long helper(long base, long ex){
        long res = 1;
        base %= MOD;

        while(ex > 0){
            if(ex % 2 == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            ex /= 2;
        }
        return res;
    }
}