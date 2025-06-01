public class Solution {
    static final int MOD = 1_000_000_007;
    static final int ALPHABET = 26;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[] freq = new long[ALPHABET];

        // Step 1: Count initial frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Build transformation matrix
        long[][] matrix = new long[ALPHABET][ALPHABET];
        for (int i = 0; i < ALPHABET; i++) {
            int count = nums.get(i);
            for (int j = 1; j <= count; j++) {
                int next = (i + j) % ALPHABET;
                matrix[next][i] = (matrix[next][i] + 1) % MOD;
            }
        }

        // Step 3: Matrix exponentiation
        long[][] powered = matrixPower(matrix, t);

        // Step 4: Multiply powered matrix with initial frequency vector
        long[] result = new long[ALPHABET];
        for (int i = 0; i < ALPHABET; i++) {
            for (int j = 0; j < ALPHABET; j++) {
                result[i] = (result[i] + powered[i][j] * freq[j]) % MOD;
            }
        }

        // Step 5: Sum the final frequencies
        long total = 0;
        for (long val : result) {
            total = (total + val) % MOD;
        }

        return (int) total;
    }

    // Matrix exponentiation
    private long[][] matrixPower(long[][] base, int exp) {
        long[][] result = identityMatrix(ALPHABET);

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiplyMatrices(result, base);
            }
            base = multiplyMatrices(base, base);
            exp >>= 1;
        }

        return result;
    }

    // Matrix multiplication
    private long[][] multiplyMatrices(long[][] a, long[][] b) {
        long[][] res = new long[ALPHABET][ALPHABET];
        for (int i = 0; i < ALPHABET; i++) {
            for (int j = 0; j < ALPHABET; j++) {
                for (int k = 0; k < ALPHABET; k++) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return res;
    }

    // Identity matrix
    private long[][] identityMatrix(int size) {
        long[][] id = new long[size][size];
        for (int i = 0; i < size; i++) {
            id[i][i] = 1;
        }
        return id;
    }
}
