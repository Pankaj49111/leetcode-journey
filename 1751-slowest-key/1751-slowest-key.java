class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        Map<Character, Integer> freq = new HashMap<>();
        for(int i=0; i<keysPressed.length(); i++){
            if(i>0){
                int diff = releaseTimes[i] - releaseTimes[i-1];
                int exVal = freq.getOrDefault(keysPressed.charAt(i),0);
                int val = Math.max(exVal, diff);
                freq.put(keysPressed.charAt(i), val);
            } else {
                int val = releaseTimes[0];
                freq.put(keysPressed.charAt(0), val);
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>(
            (a, b) -> {
                if (b.getValue().equals(a.getValue())) {
                    return b.getKey() - a.getKey();
                }
                return b.getValue() - a.getValue();
            }
        );

        heap.addAll(freq.entrySet());
        // System.out.println(heap);
        return heap.poll().getKey();
    }
}