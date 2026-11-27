class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for(String str: words){
            freq.merge(str, 1, Integer::sum);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
            Comparator.comparingInt((String s) -> freq.get(s))
            .thenComparing(Comparator.reverseOrder())
        );

        for(String s: freq.keySet()){
            pq.offer(s);
            if(pq.size() > k) pq.poll();
        }
        
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result);
        return result;
    }
}