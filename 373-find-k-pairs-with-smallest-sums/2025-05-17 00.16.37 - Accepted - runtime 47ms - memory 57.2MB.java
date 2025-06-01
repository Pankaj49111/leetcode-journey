class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0) return res;

        Queue<int[]> pq = new PriorityQueue<>
        (Comparator.comparing(a -> nums1[a[0]] + nums2[a[1]]));

        for(int i=0; i<Math.min(nums1.length, k); i++){
            pq.offer(new int[]{i,0});
        }

        while(!pq.isEmpty() && res.size() < k){
            int[] idx = pq.poll();
            int i=idx[0], j=idx[1];

            res.add(Arrays.asList(nums1[i], nums2[j]));

            if(j+1 < nums2.length){
                pq.offer(new int[]{i, j+1});
            }
        }
        return res;
    }
}