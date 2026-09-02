class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char c: s.toCharArray()){
            freq.put(c, freq.getOrDefault(c,0)+1);
        }

        int val = freq.get(s.charAt(0));

        for(char c: freq.keySet()){
            if(freq.get(c) != val) return false;
        }
        return true;
    }
}