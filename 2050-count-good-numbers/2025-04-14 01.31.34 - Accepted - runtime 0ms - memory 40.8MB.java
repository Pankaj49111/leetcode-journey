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
        if(ex == 0) return 1;

        long tmp = helper(base, ex/2);

        if(ex%2 == 0) return (tmp*tmp) % MOD;
        else return (base * tmp * tmp) % MOD;
    }
}