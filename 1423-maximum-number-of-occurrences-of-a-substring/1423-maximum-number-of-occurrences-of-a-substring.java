class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> freqMap = new HashMap<>();
        int maxCount = 0;

        for (int i = 0; i <= s.length() - minSize; i++) {
            String sub = s.substring(i, i + minSize);
            if (countUniqueChars(sub) <= maxLetters) {
                freqMap.put(sub, freqMap.getOrDefault(sub, 0) + 1);
                maxCount = Math.max(maxCount, freqMap.get(sub));
            }
        }

        return maxCount;
    }

    int countUniqueChars(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }
}
