class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        StringBuilder gcd = new StringBuilder();
        for (int i = 1; i <= minLength; i++) {
            if (str1.length() % i == 0 && str2.length() % i == 0) {
                String substr = str1.substring(0, i);
                if (isDivisor(str1, substr) && isDivisor(str2, substr)) {
                    gcd = new StringBuilder(substr);
                }
            }
        }
        return gcd.toString();
    }

    private static boolean isDivisor(String str, String substr) {
        StringBuilder temp = new StringBuilder();
        int repeats = str.length() / substr.length();
        for (int i = 0; i < repeats; i++) {
            temp.append(substr);
        }
        return temp.toString().equals(str);
    }
}