class Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        int currvowel = 0;
        for (int i = 0; i < s.length(); i++) {
            if(i < k) {
                if(isVowel(s.charAt(i))) {
                    currvowel++;
                }
            } else {
                if(isVowel(s.charAt(i))) {
                    currvowel++;
                }
                if(isVowel(s.charAt(i - k))) {
                    currvowel--;
                }
            }
            if(i >= k - 1) {
                max = Math.max(max, currvowel);
            }
        }
        return max;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}