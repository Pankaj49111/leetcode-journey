class Solution {
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, n, new StringBuilder());
        return res;
    }

    void backtrack(List<String> res, int n, StringBuilder sb){
        if(n == 0){
            res.add(sb.toString());
            return;
        }
        if((sb.length() == 0) || (sb.charAt(sb.length()-1) == '1')){
            sb.append('0');
            backtrack(res, n-1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append('1');
        backtrack(res, n-1, sb);
        sb.deleteCharAt(sb.length()-1);
    }
}