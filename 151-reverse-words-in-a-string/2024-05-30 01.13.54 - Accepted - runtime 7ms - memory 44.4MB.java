class Solution {
    public String reverseWords(String s) {
        String[] splitStr = s.split(" ");
        StringBuilder result = new StringBuilder();
        int len = splitStr.length;
        for(int i = len-1; i >= 0; i--) {
            if(splitStr[i].trim().length() != 0){
                result.append(splitStr[i].trim() + " ");
            }
        }
        return result.toString().trim();
    }
}