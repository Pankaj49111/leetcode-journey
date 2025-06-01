class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(int[] nums: matrix){
            for(int num: nums){
                pq.offer(num);

                if(pq.size() > k) pq.poll();
            }
        }
        return pq.peek();
    }
}