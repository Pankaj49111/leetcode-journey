class Solution {
    public int myAtoi(String str) {
        int len = str.length();
        int idx=0;
        while(idx<len && str.charAt(idx) == ' '){
            idx++;
        }
        boolean isNeg=false;
        if(idx<len){
            if(str.charAt(idx) == '-'){
                isNeg=true;
                ++idx;
            } else if(str.charAt(idx) == '+'){
                ++idx;
            }
        }
        int res=0;
        while(idx<len && isDigit(str.charAt(idx))){
            int digit = str.charAt(idx) - '0';
            if(res > (Integer.MAX_VALUE/10) || 
            (res == (Integer.MAX_VALUE / 10) && digit > 7)) {
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = (res*10) + digit;
            ++idx;
        }
        return isNeg ? -res : res;
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}