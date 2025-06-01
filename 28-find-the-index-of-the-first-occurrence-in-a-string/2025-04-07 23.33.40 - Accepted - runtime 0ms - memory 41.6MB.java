class Solution {
    public int strStr(String haystack, String needle) {
        int i=0, j=needle.length();

        while(j<=haystack.length()){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(haystack.substring(i,j).equals(needle)) return i;
            }

            i++; j++;
        }
        return -1;
    }
}