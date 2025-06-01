class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        dfs(rooms, vis, 0);

        for(boolean visited: vis){
            if(!visited) return false;
        }

        return true;
    }

    void dfs(List<List<Integer>> rooms, boolean[] vis, int currRoom){
        vis[currRoom] = true;

        for(int room : rooms.get(currRoom)){
            if(!vis[room]){
                dfs(rooms, vis, room);
            }
        }
    }
}