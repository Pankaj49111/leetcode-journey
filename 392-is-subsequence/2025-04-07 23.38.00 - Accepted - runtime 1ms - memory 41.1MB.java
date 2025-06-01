class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0, j=0;
        int slen = s.length(), tlen = t.length();

        while(i<slen && j<tlen){
            if(s.charAt(i) == t.charAt(j)) i++;

            j++;
        }
        return i==slen;
    }
}