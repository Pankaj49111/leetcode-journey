class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] arr = new int[26];

        int i=0;
        while(i<s.length()){
            arr[(s.charAt(i)-'a')]++;
            arr[(t.charAt(i)-'a')]--;
            i++;
        }
        return !Arrays.stream(arr).anyMatch(c -> c != 0);
    }
}