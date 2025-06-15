class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> -(a[0]*a[0] + a[1]*a[1]) + (b[0]*b[0] + b[1]*b[1]));

        for(int[] point: points){
            pq.add(point);

            if(pq.size() > k) pq.poll();
        }
        int[][] res = new int[pq.size()][2];

        int i=0;
        while(!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        return res;
    }
}