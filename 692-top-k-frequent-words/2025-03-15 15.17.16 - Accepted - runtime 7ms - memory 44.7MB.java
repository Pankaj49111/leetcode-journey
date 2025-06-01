class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for(String word: words) {
            freqMap.put(word, freqMap.getOrDefault(word,0)+1);
        }

        List<String> res = new ArrayList<>(freqMap.keySet());

        Collections.sort(res, (w1, w2) -> freqMap.get(w1).equals(freqMap.get(w2))
                    ? w1.compareTo(w2) : freqMap.get(w2) - freqMap.get(w1));

        return res.subList(0, k);
    }
}