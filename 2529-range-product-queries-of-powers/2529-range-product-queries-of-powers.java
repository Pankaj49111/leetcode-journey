class Solution {
    public int[] productQueries(int n, int[][] queries) {
        final int MOD = 1_000_000_007;

        List<Integer> powers = new ArrayList<>();
        int powerIndex = 0;

        while (n > 0) {
            if (n % 2 == 1) {
                powers.add((int)Math.pow(2, powerIndex));
            }
            n /= 2;
            powerIndex++;
        }

        long[] prefixProduct = new long[powers.size()];
        prefixProduct[0] = powers.get(0);

        for (int i = 1; i < powers.size(); i++) {
            prefixProduct[i] = (prefixProduct[i - 1] * powers.get(i)) % MOD;
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            if (left == 0) {
                result[i] = (int) prefixProduct[right];
            } else {
                long inv = modInverse(prefixProduct[left - 1], MOD);
                result[i] = (int)((prefixProduct[right] * inv) % MOD);
            }
        }

        return result;
    }

    private long modInverse(long a, int mod) {
        return powMod(a, mod - 2, mod);
    }
    private long powMod(long base, int exponent, int mod) {
        long result = 1;
        base = base % mod;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent >>= 1;
        }
        return result;
    }
}
