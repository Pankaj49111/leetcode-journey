class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 0;
        long high = (long) ranks[0] * (long) cars * cars;

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (canRepairInTime(ranks, cars, mid)) {
                high = mid; // Try for a smaller time
            } else {
                low = mid + 1; // Need more time
            }
        }

        return low;
    }

    private boolean canRepairInTime(int[] ranks, int cars, long time) {
        long totalCarsRepaired = 0;

        for (int rank : ranks) {
            totalCarsRepaired += (long) Math.sqrt(time / rank);
        }

        return totalCarsRepaired >= cars; // Can we repair all cars within 'time'?
    }
}