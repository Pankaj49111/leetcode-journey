class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));

        for(int[] c: classes){
            double gain = calGain(c[0], c[1]);
            pq.offer(new double[]{gain, c[0], c[1]});
        }

        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1] + 1;
            int total = (int) top[2] + 1;
            double gain = calGain(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }

        double totalRatio = 0.0;
        for (double[] arr : pq) {
            totalRatio += arr[1] / arr[2];
        }
        
        return totalRatio / classes.length;
    }

    private double calGain(int pass, int total) {
        return ((double)(pass + 1) / (total + 1)) - ((double)pass / total);
    }
}