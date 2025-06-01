class Solution {
    public int lengthOfLastWord(String s) {
        String[] spArr = s.split("\\s");
        return spArr[spArr.length - 1].length();
    }
}