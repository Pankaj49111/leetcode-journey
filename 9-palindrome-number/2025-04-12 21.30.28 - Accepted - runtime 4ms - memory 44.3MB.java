class Solution {
    public boolean isPalindrome(int x) {
        int tmp = x;
        int rev = 0;

        while(tmp > 0){
            int rem = tmp % 10;
            rev = rev * 10 + rem;
            tmp /= 10;
        }

        return rev == x;
    }
}