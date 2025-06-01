class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.offer(0); vis[0] = true;
        int visCnt = 1;

        while(!q.isEmpty()){
            int currRoom = q.poll();

            for(int room : rooms.get(currRoom)){
                if(!vis[room]){
                    q.offer(room);
                    vis[room] = true;
                    visCnt++;
                }
            }
        }
        return visCnt == n;
    }
}