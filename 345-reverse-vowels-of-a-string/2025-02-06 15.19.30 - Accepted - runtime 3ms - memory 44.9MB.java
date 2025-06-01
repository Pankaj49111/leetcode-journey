class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i=0, j=chars.length-1;

        while(i<j){
            while(i<j && !isVowel(chars[i])) i++;
            while(i<j && !isVowel(chars[j])) j--;

            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++; j--;
        }

        return new String(chars);
    }

    public boolean isVowel(char ch){
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}