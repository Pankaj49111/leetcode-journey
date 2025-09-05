class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {
            long remaining = (long) num1 - (long) k * num2;
            if (remaining < 0) continue;

            int bits = Long.bitCount(remaining);
            if (bits <= k && k <= remaining) {
                return k;
            }
        }
        return -1;
    }
}
