class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        int i=0, j=s.length()-1;

        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))) i++;
            else if(!Character.isLetterOrDigit(s.charAt(j))) j--;
            else if(!String.valueOf(s.charAt(i)).equalsIgnoreCase(String.valueOf(s.charAt(j)))) return false;
            else {
                i++; j--;
            }
        }
        return true;
    }
}