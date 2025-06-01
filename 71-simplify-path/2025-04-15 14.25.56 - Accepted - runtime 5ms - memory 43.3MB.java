class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] split = path.split("/");

        for(String dir : split) {
            if(!dir.isEmpty() && !dir.equalsIgnoreCase(".")){
                if(dir.equalsIgnoreCase("..")){
                    if(!st.isEmpty()) st.pop();
                } else {
                    st.push(dir);
                }
            }
        }
        return "/"+String.join("/", st);
    }
}