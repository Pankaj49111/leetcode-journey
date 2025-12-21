class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();

        int caps = 0;

        for(char c: word.toCharArray()){
            if(Character.isUpperCase(c)) caps++;
        }
        if(caps == n) return true;
        else if(caps == 1 && Character.isUpperCase(word.charAt(0))) return true;
        else if(caps == 0) return true;

        return false;
    }
}