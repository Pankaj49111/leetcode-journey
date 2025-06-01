class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int MOD = 1_000_000_007;
        long[] freq = new long[26];

        for (char c : s.toCharArray()) {
            int dist = 'z' - c;
            freq[dist]++;
        }

        for (int step = 0; step < t; step++) {
            long[] nextFreq = new long[26];
            for (int i = 0; i < 26; i++) {
                if (i == 0) {
                    nextFreq[25] = (nextFreq[25] + freq[0]) % MOD;
                    nextFreq[24] = (nextFreq[24] + freq[0]) % MOD;
                } else {
                    nextFreq[i - 1] = (nextFreq[i - 1] + freq[i]) % MOD;
                }
            }
            freq = nextFreq;
        }

        long len = 0;
        for(long count: freq){
            len = (len+count)%MOD;
        }

        return (int)len;
    }
}