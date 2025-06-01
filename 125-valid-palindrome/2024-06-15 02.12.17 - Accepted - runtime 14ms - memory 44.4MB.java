class Solution {
    public boolean isPalindrome(String s) {
        String newStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = newStr.length();
        int i = 0, j = n - 1;
        while(i<j){
            if(newStr.charAt(i) != newStr.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}