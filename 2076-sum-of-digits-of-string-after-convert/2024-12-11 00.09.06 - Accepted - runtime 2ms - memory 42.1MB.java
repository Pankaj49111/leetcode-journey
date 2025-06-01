import java.math.BigInteger;

class Solution {
    public int getLucky(String s, int k) {
        StringBuilder convert = new StringBuilder();

        for(char c: s.toCharArray()){
            convert.append(String.valueOf(c-'a'+1));
        }
        String transform = convert.toString();
        
        while(k-->0){
            int sum=0;
            for(char ch: transform.toCharArray()){
                sum += ch-'0';
            }
            transform = ""+sum;
        }
        return Integer.parseInt(transform);
    }
}