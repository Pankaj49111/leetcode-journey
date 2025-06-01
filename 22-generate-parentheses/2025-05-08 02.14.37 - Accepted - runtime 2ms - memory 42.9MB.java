class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAll(new char[2 * n], 0, result);
        return result;
    }

    void generateAll(char[] ch, int idx, List<String> result){
        if(idx == ch.length){
            if(isValid(ch)){
                result.add(new String(ch));
            }
            return;
        }

        ch[idx] = '(';
        generateAll(ch, idx+1, result);

        ch[idx] = ')';
        generateAll(ch, idx+1, result);
    }

    boolean isValid(char[] chs){
        int bal = 0;
        for(char ch: chs){
            if(ch == '(') bal++;
            else bal--;

            if(bal < 0) return false;
        }
        return bal == 0;
    }
}