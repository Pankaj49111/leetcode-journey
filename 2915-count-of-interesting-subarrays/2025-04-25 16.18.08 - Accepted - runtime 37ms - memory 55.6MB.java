class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> modCount = new HashMap<>();
        modCount.put(0, 1L);

        int prefix = 0;
        long count = 0;

        for (int num : nums) {
            if (num % modulo == k) {
                prefix++;
            }

            // Find target prefix mod
            int target = (prefix - k + modulo) % modulo;

            count += modCount.getOrDefault(target, 0L);

            int currentMod = prefix % modulo;
            modCount.put(currentMod, modCount.getOrDefault(currentMod, 0L) + 1);
        }

        return count;
    }
}