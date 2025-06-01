class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        int i=0, j=s.length()-1;

        while(i<j){
            char s1 = s.charAt(i);
            char s2 = s.charAt(j);

            if(!Character.isLetterOrDigit(s1)) i++;
            else if(!Character.isLetterOrDigit(s2)) j--;
            else if(!String.valueOf(s1).equalsIgnoreCase(String.valueOf(s2))){
                return false;
            } else {
                i++;j--;
            }
        }
        return true;
    }
}