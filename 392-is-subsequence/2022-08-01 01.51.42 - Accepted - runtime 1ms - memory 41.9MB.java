class Solution {
    private boolean isSubsequence(String s, String t, int m, int n){
        if(m < 0) return true;
        if(n < 0) return false;
        if(s.charAt(m) == t.charAt(n)) return isSubsequence(s, t, m - 1, n - 1);
        return isSubsequence(s, t, m, n - 1);
    }
    public boolean isSubsequence(String s, String t) {
        return isSubsequence(s, t, s.length() - 1 , t.length() - 1);
    }
}