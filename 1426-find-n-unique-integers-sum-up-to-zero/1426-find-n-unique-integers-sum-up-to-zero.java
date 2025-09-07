class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int value = -(n / 2);

        for (int i = 0; i < n; i++) {
            // If n is even, we skip 0 to avoid duplicate zero
            if (n % 2 == 0 && value == 0) {
                value++;
            }
            result[i] = value++;
        }

        return result;
    }
}