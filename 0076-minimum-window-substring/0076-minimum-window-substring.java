class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length()) return "";

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int i = 0, j = 0;
        int valid = 0;

        int start = 0, len = Integer.MAX_VALUE;

        while (j < s.length()) {
            char c = s.charAt(j);
            j++;
            
            if (freq.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).intValue() == freq.get(c).intValue()) {
                    valid++;
                }
            }

            while (valid == freq.size()) {
                if (j - i < len) {
                    start = i;
                    len = j - i;
                }
                
                char d = s.charAt(i);
                i++;
                
                if (freq.containsKey(d)) {
                    if (window.get(d).intValue() == freq.get(d).intValue()) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
