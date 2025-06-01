class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] s1 = s.toCharArray(); Arrays.sort(s1);
        char[] t1 = t.toCharArray(); Arrays.sort(t1);

        int i=0;
        while(i<s.length()){
            if(s1[i] != t1[i]) return false;
            i++;
        }
        return true;
    }
}