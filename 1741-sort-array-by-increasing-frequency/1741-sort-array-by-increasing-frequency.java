class Solution {
    // class Pair{
    //     int k;
    //     int v;
    //     Pair(int _k, int _v){
    //         this.k = _k;
    //         this.v = _v;
    //     }
    // }
    public int[] frequencySort(int[] nums) {
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return b.getKey() - a.getKey();
            } else {
                return a.getValue() - b.getValue();
            }
        });


        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        pq.addAll(map.entrySet());

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(entry.getKey());
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}