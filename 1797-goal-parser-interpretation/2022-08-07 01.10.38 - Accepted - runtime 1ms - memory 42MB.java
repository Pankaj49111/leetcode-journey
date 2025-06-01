class Solution {
    public String interpret(String cmd) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<cmd.length(); i++){
            char ch = cmd.charAt(i);
            if(ch != '(' && ch != ')'){
                sb.append(""+ch);
            }
            else if(ch == '(' && cmd.charAt(i+1) == ')'){
                sb.append(""+'o');
            }
            else if((ch == '(' && cmd.charAt(i+1) != ')') || ch==')'){
                continue;
            }
        }
        return sb.toString();
    }
}