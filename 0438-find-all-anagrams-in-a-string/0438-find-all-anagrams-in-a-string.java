class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = p.length();
        int m = s.length();
        if (n > m) {
            return res;
        }

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            windowFreq[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pFreq, windowFreq)) {
            res.add(0);
        }

        for (int i = n; i < m; i++) {
            windowFreq[s.charAt(i) - 'a']++;
            windowFreq[s.charAt(i - n) - 'a']--;

            if (Arrays.equals(pFreq, windowFreq)) {
                res.add(i - n + 1);
            }
        }

        return res;
    }
}
