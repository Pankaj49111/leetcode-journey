class Solution {
    private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public long countOfSubstrings(String word, int k) {
        if (k > word.length() || !hasAllVowels(word)) return 0;
        return atLeastK(word, k) - atLeastK(word, k + 1);
    }

    private boolean hasAllVowels(String word) {
        Set<Character> foundVowels = new HashSet<>();
        for (char ch : word.toCharArray()) {
            if (isVowel(ch)) foundVowels.add(ch);
            if (foundVowels.size() == 5) return true;
        }
        return false;
    }

    private boolean isVowel(char ch) {
        return vowels.contains(ch);
    }

    private long atLeastK(String word, int k) {
        int n = word.length();
        int cons = 0, i = 0;
        long ans = 0;
        int[] vowelCount = new int[26]; // Using 26 to avoid out-of-bounds errors
        int uniqueVowels = 0;

        for (int j = 0; j < n; j++) {
            char ch = word.charAt(j);
            if (isVowel(ch)) {
                int index = ch - 'a';
                if (vowelCount[index] == 0) uniqueVowels++;
                vowelCount[index]++;
            } else {
                cons++;
            }

            while (uniqueVowels == 5 && cons >= k) {
                ans += n - j;
                char left = word.charAt(i);
                if (isVowel(left)) {
                    int index = left - 'a';
                    vowelCount[index]--;
                    if (vowelCount[index] == 0) uniqueVowels--;
                } else {
                    cons--;
                }
                i++;
            }
        }
        return ans;
    }
}
