class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> comb = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return comb;
        }
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        findComb(0, new StringBuilder(), comb, map, digits);
        return comb;
    }

    public void findComb(int idx, StringBuilder output, List<String> comb, String[] map, String digits){
        if(idx == digits.length()){
            comb.add(output.toString());
            return;
        } 
        
        String letters = map[digits.charAt(idx)-'0'];
        for(char ch : letters.toCharArray()){
            output.append(ch);
            findComb(idx+1, output, comb, map, digits);
            output.deleteCharAt(output.length() - 1);
        }
    }
}