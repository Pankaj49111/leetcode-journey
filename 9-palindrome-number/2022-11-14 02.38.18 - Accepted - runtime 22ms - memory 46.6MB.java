class Solution {
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        String revnum = new StringBuilder(num).reverse().toString();
        
        
        return num.equals(revnum) ? true: false;
    }
}