class Solution {
    public int lengthOfLastWord(String s) {
        String[] spArr = s.trim().split(" ");
        return spArr[spArr.length - 1].length();
    }
}