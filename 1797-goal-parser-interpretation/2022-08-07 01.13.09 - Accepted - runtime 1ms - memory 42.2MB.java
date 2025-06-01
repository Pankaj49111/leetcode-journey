class Solution {
    public String interpret(String cmd) {
        return cmd.replace("()","o").replace("(al)","al");
    }
}