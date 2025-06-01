class Solution {
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        String revnum = new StringBuilder(String.valueOf(x)).reverse().toString();
        
        
        return num.equals(revnum) ? true: false;
    }
}