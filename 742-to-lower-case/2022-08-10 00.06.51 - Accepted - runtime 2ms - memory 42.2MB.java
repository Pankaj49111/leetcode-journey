class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)){
                ch = (char)(ch | (char)32);
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}