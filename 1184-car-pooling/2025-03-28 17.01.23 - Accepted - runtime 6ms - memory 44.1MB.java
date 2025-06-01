class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> Integer.compare(a[1], b[1]));
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);

        for(int[] trip : trips){
            // means prev trip is completed
            while(!pq.isEmpty() && pq.peek()[2] <= trip[1]){ 
                capacity += pq.poll()[0];
            }
            
            capacity -= trip[0];
            pq.offer(trip);
            if(capacity < 0) return false;
        }
        return true;
    }
}