class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );

        pq.addAll(freqMap.entrySet());

        int maxFreq = pq.peek().getValue();
        int sum = 0;

        while (!pq.isEmpty() && pq.peek().getValue() == maxFreq) {
            sum += pq.poll().getValue();
        }

        return sum;
    }
}
