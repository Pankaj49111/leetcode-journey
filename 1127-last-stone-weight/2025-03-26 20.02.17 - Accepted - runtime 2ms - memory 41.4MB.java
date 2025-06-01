class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(int stone: stones) pq.offer(stone);

        while (!pq.isEmpty()){
            int last = pq.poll();
            if(!pq.isEmpty()){
                int secondlast = pq.poll();
                if(last == secondlast){
                    continue;
                } else {
                    pq.offer(last-secondlast);
                }
            } else {
                return last;
            }
        }
        return 0;
    }
}