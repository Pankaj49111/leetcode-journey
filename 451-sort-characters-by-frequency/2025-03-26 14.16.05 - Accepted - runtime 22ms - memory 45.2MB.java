class Solution {
    public String frequencySort(String s) {
        Map<Character, Long> map = s.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(a -> a, Collectors.counting()));

        PriorityQueue<Map.Entry<Character, Long>> pq = new PriorityQueue<>
                ((a,b) -> b.getValue().intValue() - a.getValue().intValue());

        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();

        int size = pq.size();
        while (size-- > 0){
            Map.Entry<Character, Long> entry = pq.poll();
            sb.repeat(entry.getKey(), entry.getValue().intValue());
        }
        return sb.toString();
    }
}