class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums){
            freq.merge(num, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        for(Map.Entry<Integer, Integer> e: freq.entrySet()){
            pq.offer(e);
            if(pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}