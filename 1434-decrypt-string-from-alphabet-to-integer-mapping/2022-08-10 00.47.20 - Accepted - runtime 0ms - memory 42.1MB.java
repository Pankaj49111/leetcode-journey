class Solution {
    public String freqAlphabets(String s) {
        
        StringBuilder output = new StringBuilder();
        int i=s.length()-1;
        while(i>=0){
            if(s.charAt(i) == '#'){
                output.append((char)('a' + (s.charAt(i-1) -'0' ) + 10*(s.charAt(i-2)-'0') -1) ); 
                i -= 3; 
            } else {
                output.append((char)('a' + (s.charAt(i) - '0') -1));
                i--;
            }
        }
        return output.reverse().toString();
    }
}