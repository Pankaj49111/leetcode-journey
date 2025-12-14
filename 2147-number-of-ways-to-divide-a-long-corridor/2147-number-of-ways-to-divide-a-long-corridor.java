class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;

        int totalSeats = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'S') totalSeats++;
        }

        // If total seats is odd or zero, impossible
        if (totalSeats == 0 || totalSeats % 2 != 0) return 0;

        long ways = 1;
        int seatCount = 0;
        int plantCount = 0;

        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                seatCount++;

                // Every time we complete a pair
                if (seatCount > 2 && seatCount % 2 == 1) {
                    ways = (ways * (plantCount + 1)) % MOD;
                    plantCount = 0;
                }
            } else if (seatCount >= 2 && seatCount % 2 == 0) {
                // Counting plants between seat pairs
                plantCount++;
            }
        }

        return (int) ways;
    }
}
