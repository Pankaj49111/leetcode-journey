class Solution {
    public String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i=split.length-1; i>=0; i--){
            sb.append(split[i]+" ");
        }
        return sb.reverse().toString().trim();
    }
}