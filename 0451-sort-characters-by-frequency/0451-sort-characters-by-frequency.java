class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());

        for(Map.Entry<Character, Integer> e :map.entrySet()){
            pq.offer(e);
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            var e = pq.poll();
            sb.append(String.valueOf(e.getKey()).repeat(e.getValue()));
        }
        return sb.toString();
    }
}