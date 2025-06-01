class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if((str1+str2).equals(str2+str1)){
            int a = str1.length();
            int b = str2.length();
            return str1.substring(0,gcd(a,b));
        }else{
            return "";
        }
    }

    public Integer gcd(int a, int b){
        while(b%a != 0) {
            int rem = b%a;
            b = a;
            a = rem;
        }
        return a;
    }
}