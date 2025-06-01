class Solution {
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        int flag = 0;
        for(int i=0; i<num.length(); i++){
            if(num.charAt(i) != num.charAt(num.length()-1-i)){
                flag = 1;
                break;
            }
        }
        return flag == 0 ? true: false;
    }
}