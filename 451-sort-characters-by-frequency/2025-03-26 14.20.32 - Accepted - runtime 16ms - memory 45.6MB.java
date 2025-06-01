class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>
                ((a,b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();

        int size = pq.size();
        while (size-- > 0){
            Map.Entry<Character, Integer> entry = pq.poll();
            sb.repeat(entry.getKey(), entry.getValue());
        }
        return sb.toString();
    }
}