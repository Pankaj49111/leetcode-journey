class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length; 
        int[][] projects = new int[n][2];

        for(int i=0; i<n; i++){
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        Arrays.sort(projects, (a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int idx=0;
        for(int cnt = 0; cnt < k; cnt++){
            while(idx < n && projects[idx][0] <= w){
                pq.offer(projects[idx][1]);
                idx++;
            }
            if(pq.isEmpty()) break;
            w += pq.poll();
        }
        return w;
    }
}