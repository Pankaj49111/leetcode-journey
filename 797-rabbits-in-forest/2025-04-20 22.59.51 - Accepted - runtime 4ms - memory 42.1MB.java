class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int ans: answers){
            map.put(ans, map.getOrDefault(ans,0)+1);
        }

        int total = 0;
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            total += Math.ceil((double)e.getValue()/(e.getKey()+1)) * (e.getKey()+1);
        }
        return total;
    }
}