class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack s1 = new Stack<>();
        Stack s2 = new Stack<>();

        for(char c: s.toCharArray()){
            if(c == '#') {
                if(!s1.isEmpty()) s1.pop();
            }
            else s1.push(c);
        }
        for(char c: t.toCharArray()){
            if(c == '#') {
                if(!s2.isEmpty()) s2.pop();
            }
            else s2.push(c);
        }

        if(s1.size() != s2.size()) return false;

        while(!s1.isEmpty() && !s2.isEmpty()){
            if(s1.pop() != s2.pop()) return false;
        }
        return true;
    }
}