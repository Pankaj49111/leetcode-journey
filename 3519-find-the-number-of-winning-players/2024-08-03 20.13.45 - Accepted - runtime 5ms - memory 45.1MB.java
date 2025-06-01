class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();

        for(int[] p: pick){
            map.computeIfAbsent(p[0], k-> new HashMap<>()).merge(p[1], 1, Integer::sum);
        }

        int winCount = 0;

        for(int i=0; i<n; i++){
            if(map.containsKey(i)){
                Map<Integer, Integer> colorMap = map.get(i);
                for(int color : colorMap.keySet()){
                    if(colorMap.get(color) > i){
                        winCount++;
                        break;
                    }
                }
            }
        }
        return winCount;
    }
}