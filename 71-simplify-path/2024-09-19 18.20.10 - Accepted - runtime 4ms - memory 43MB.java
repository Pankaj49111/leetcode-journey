class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        
        for(String input: split){
            if(input != "" && !input.equalsIgnoreCase(".")){
                if(input.equalsIgnoreCase("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                } else {
                    stack.push(input);
                }
            }
        }

        List<String> list = new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        for(int i=list.size()-1; i>=0; i--){
            sb.append("/");
            sb.append(list.get(i));
        }

        if(sb.toString().equalsIgnoreCase("")){
            sb.append("/");
        }

        return sb.toString();
    }
}