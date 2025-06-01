class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len = Math.min(word1.length(), word2.length());
        return concatAlter(len, word1, word2);
    }

    public String concatAlter(int len, String word1, String word2){
        StringBuilder result = new StringBuilder();
        int i=0;
        for(i=0; i<len; i++){
            result.append(String.valueOf(word1.charAt(i)) + String.valueOf(word2.charAt(i)));
        }
        if(i < word2.length()){
            result.append(word2.substring(i));
        } else if(i < word1.length()){
            result.append(word1.substring(i));
        }
        return result.toString();
    }
}