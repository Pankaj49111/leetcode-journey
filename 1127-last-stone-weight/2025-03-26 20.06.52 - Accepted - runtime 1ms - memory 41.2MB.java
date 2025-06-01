class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(int stone: stones) pq.offer(stone);

        while (pq.size() > 1){
            int last = pq.poll();
            int secondlast = pq.poll();
            if(last != secondlast){
                pq.offer(last-secondlast);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}