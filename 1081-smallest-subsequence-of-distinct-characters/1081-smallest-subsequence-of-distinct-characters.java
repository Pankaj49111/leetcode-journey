class Solution {
    public String smallestSubsequence(String s) {
        int[] count = new int[26];
        for(char c: s.toCharArray()) count[c-'a']++;

        boolean[] present = new boolean[26];
        Stack<Character> st = new Stack<>();

        for(char c: s.toCharArray()){
            count[c-'a']--;

            if(present[c-'a']) continue;

            while(!st.isEmpty() && c < st.peek() && count[st.peek() - 'a'] > 0){
                present[st.pop() - 'a'] = false;
            }

            st.push(c);
            present[c-'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(char c: st) sb.append(c);

        return sb.toString();
    }
}