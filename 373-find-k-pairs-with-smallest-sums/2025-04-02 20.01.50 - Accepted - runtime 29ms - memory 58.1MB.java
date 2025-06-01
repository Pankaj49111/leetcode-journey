class Solution {
    public List<List<Integer>> kSmallestPairs(int[] n1, int[] n2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n1.length == 0 || n2.length == 0 || k==0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]+a[1]) - (b[0]+b[1]));

        for(int i=0; i<Math.min(n1.length, k); i++){
            pq.offer(new int[]{n1[i], n2[0], 0});
        }

        for(int i=0; i<k && !pq.isEmpty(); i++){
            int[] curr = pq.poll();
            
            // Add the current pair to the result list
            res.add(Arrays.asList(curr[0], curr[1]));
            
            // If there is a next element in nums2, add the new pair to the heap
            int n2Idx = curr[2];
            if(n2Idx < n2.length - 1){
                pq.offer(new int[]{curr[0], n2[n2Idx+1], n2Idx + 1});
            }
        }
        return res;
    }
}