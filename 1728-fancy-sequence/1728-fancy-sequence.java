class Fancy {
    private static final int MOD = 1_000_000_007;

    private List<Long> sequence = new ArrayList<>();
    private List<Long> historyMult = new ArrayList<>();
    private List<Long> historyAdd = new ArrayList<>();
    
    private long totalMult = 1;
    private long totalAdd = 0;

    public void append(int val) {
        sequence.add((long) val);
        historyMult.add(totalMult);
        historyAdd.add(totalAdd);
    }

    public void addAll(int inc) {
        totalAdd = (totalAdd + inc) % MOD;
    }

    public void multAll(int m) {
        totalMult = (totalMult * m) % MOD;
        totalAdd = (totalAdd * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= sequence.size()) return -1;

        long val = sequence.get(idx);
        long pastMult = historyMult.get(idx);
        long pastAdd = historyAdd.get(idx);

        // Apply inverse of pastMult
        long inv = modInverse(pastMult, MOD);

        // Restore original base value
        long curr = val * ((totalMult * inv) % MOD) % MOD;

        // Adjust addAll impact
        long addImpact = (totalAdd - (pastAdd * ((totalMult * inv) % MOD)) % MOD + MOD) % MOD;

        return (int) ((curr + addImpact) % MOD);
    }

    // Fermat's Little Theorem for modular inverse
    private long modInverse(long a, int mod) {
        return modPow(a, mod - 2, mod);
    }

    private long modPow(long base, int exp, int mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */