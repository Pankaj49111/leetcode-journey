class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length) return nums;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((k1, k2) ->
            map.get(k1) - map.get(k2)
        );

        for(int n: map.keySet()){
            pq.offer(n);
            if(pq.size() > k) pq.poll();
        }

        int[] result = new int[k];
        for (int i = k-1; i >= 0; i--) {
            result[i] = pq.poll();
        }
        return result;
    }
}