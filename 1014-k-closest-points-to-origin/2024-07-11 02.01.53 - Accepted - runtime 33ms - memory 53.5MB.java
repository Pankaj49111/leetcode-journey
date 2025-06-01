class Pair{
    int f;
    int s;
    int sq;
    public Pair(int _f, int _s, int _sq){
        this.f = _f;
        this.s = _s;
        this.sq = _sq;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(b.sq, a.sq));

        for(int[] ele : points){
            pq.add(new Pair(ele[0], ele[1], ele[0]*ele[0] + ele[1]*ele[1]));
            
            if(pq.size() > k){
                pq.poll();
            }
        }

        List<int[]> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            res.add(new int[]{pair.f, pair.s});
        }
        return res.toArray(new int[res.size()][]);
    }
}