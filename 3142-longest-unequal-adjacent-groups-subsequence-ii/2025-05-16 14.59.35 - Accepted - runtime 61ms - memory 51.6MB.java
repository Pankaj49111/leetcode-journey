public class Solution {
    // Helper function to check if the Hamming distance between two words is exactly 1
    private boolean isHammingDistanceOne(String word1, String word2) {
        int diffCount = 0;
        if (word1.length() != word2.length()) return false;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
                if (diffCount > 1) return false;  // More than 1 difference, not valid
            }
        }
        return diffCount == 1;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String> bestSequence = new ArrayList<>();
        
        // DP array to store the longest subsequence ending at each word
        List<List<String>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp.add(new ArrayList<>());
        }

        // Build the subsequences
        for (int i = 0; i < n; i++) {
            dp.get(i).add(words[i]); // Start with the word itself in the subsequence
            for (int j = 0; j < i; j++) {
                // Check if words[i] and words[j] differ by exactly 1 character and have different groups
                if (isHammingDistanceOne(words[i], words[j]) && groups[i] != groups[j]) {
                    // If this is a longer subsequence, update dp[i]
                    if (dp.get(i).size() < dp.get(j).size() + 1) {
                        dp.get(i).clear();
                        dp.get(i).addAll(dp.get(j));
                        dp.get(i).add(words[i]);
                    }
                }
            }
        }
        
        for (List<String> seq : dp) {
            if (seq.size() > bestSequence.size()) {
                bestSequence = seq;
            }
        }

        return bestSequence;
    }
}
