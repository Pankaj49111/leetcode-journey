class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int i = 0, maxCount = 0, result = 0;

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            count[c - 'A']++;
            maxCount = Math.max(maxCount, count[c - 'A']);

            while ((j - i + 1) - maxCount > k) {
                count[s.charAt(i) - 'A']--;
                i++;
            }

            result = Math.max(result, j - i + 1);
        }

        return result;
    }
}
