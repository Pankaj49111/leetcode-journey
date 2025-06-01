class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        int length = 0;
        boolean hasCenter = false;

        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        for (String word : countMap.keySet()) {
            String rev = new StringBuilder(word).reverse().toString();

            if (!word.equals(rev)) {
                if (countMap.containsKey(rev)) {
                    int pairs = Math.min(countMap.get(word), countMap.get(rev));
                    length += pairs * 4;
                    
                    countMap.put(word, countMap.get(word) - pairs);
                    countMap.put(rev, countMap.get(rev) - pairs);
                }
            }
        }

        for (String word : countMap.keySet()) {
            if (word.charAt(0) == word.charAt(1)) {
                int count = countMap.get(word);
                length += (count / 2) * 4;
                if (count % 2 == 1) {
                    hasCenter = true;
                }
            }
        }

        if (hasCenter) {
            length += 2;
        }

        return length;
    }
}