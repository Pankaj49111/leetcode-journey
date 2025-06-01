class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        
        if (s == null || words == null || words.length == 0) return ans;
        
        int n = words.length;          // number of words
        int wordLen = words[0].length();  // length of each word
        int totalLen = n * wordLen;      // total length of the concatenated string
        
        // Create a frequency map for words in 'words'
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Sliding window approach
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> currentCount = new HashMap<>();
            
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                
                // If the word is part of the list, process it
                if (wordCount.containsKey(word)) {
                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                    count++;
                    
                    // If the word count exceeds the frequency in wordCount, move left pointer
                    while (currentCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                    
                    // If we've matched all words
                    if (count == n) {
                        ans.add(left);
                        
                        // Move left pointer to continue searching
                        String leftWord = s.substring(left, left + wordLen);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    // Reset window if the word isn't in wordCount
                    currentCount.clear();
                    left = right;
                    count = 0;
                }
            }
        }
        
        return ans;
    }
}
