class Solution {
    public String mergeAlternately(String word1, String word2) {
        if(word1.length() < word2.length()) {
            return concatAlter(word1.length(), word1, word2);
        } else {
            return concatAlter(word2.length(), word1, word2);
        }
    }

    public String concatAlter(int len, String word1, String word2){
        String result = "";
        for(int i=0; i<len; i++){
            result += String.valueOf(word1.charAt(i)) + String.valueOf(word2.charAt(i));
        }
        if(word2.length() - word1.length() > 0){
            for(int i = word1.length(); i < word2.length(); i++){
                result += String.valueOf(word2.charAt(i));
            }
        } else if(word1.length() - word2.length() > 0){
            for(int i = word2.length(); i < word1.length(); i++){
                result += String.valueOf(word1.charAt(i));
            }
        }
        return result;
    }
}