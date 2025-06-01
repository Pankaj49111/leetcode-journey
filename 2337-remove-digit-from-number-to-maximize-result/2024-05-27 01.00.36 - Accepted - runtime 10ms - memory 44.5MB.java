import java.math.BigInteger;
class Solution {
    public String removeDigit(String number, char digit) {
        BigInteger max = BigInteger.ZERO;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                max = max(max, 
                new BigInteger(number.substring(0, i) + number.substring(i + 1)));
            }
        }
        // if(max == BigInteger.ZERO) return "";
        return String.valueOf(max);
    }

    public static BigInteger max(BigInteger a, BigInteger b) {
        return a.compareTo(b) > 0 ? a : b;
    }
}