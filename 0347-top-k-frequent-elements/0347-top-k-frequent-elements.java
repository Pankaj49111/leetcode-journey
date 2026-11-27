class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num: nums){
            freq.merge(num, 1, Integer::sum);
        }

        Queue<Integer> pq = new PriorityQueue<>((a,b) -> freq.get(a) - freq.get(b));
        for(int f: freq.keySet()){
            pq.offer(f);
            if(pq.size() > k) pq.poll();
        }
        int[] res = new int[pq.size()];
        int idx=0;
        while(!pq.isEmpty()){
            res[idx++] = pq.poll();
        }
        return res;
    }
}