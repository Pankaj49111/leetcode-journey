class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int i = 0, j = 0;
        int minLen = Integer.MAX_VALUE; 
        int minStart = 0; 
        int required = t.length(); // Number of characters needed to form a valid window

        char[] chars = s.toCharArray();

        while (j < chars.length) {
            if (freq[chars[j]]-- > 0) {
                required--; // Needed character found
            }

            // Contract the window
            while (required == 0) {
                if ((j - i + 1) < minLen) {
                    minLen = j - i + 1;
                    minStart = i;
                }

                if (++freq[chars[i]] > 0) {
                    required++; // A required character is now missing
                }
                i++;
            }
            j++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}