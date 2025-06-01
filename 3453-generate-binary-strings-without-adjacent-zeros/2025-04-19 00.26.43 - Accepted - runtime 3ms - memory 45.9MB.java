class Solution {
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, n, "");
        return res;
    }

    void backtrack(List<String> res, int n, String sb){
        if(n == sb.length()){
            res.add(sb);
            return;
        }

        // sb.append('1');
        backtrack(res, n, sb+"1");

        if((sb.length() == 0) || (sb.charAt(sb.length()-1) == '1')){
            // sb.append('0');
            backtrack(res, n, sb+"0");
            // sb.deleteCharAt(sb.length()-1);
        }
        
        // sb.deleteCharAt(sb.length()-1);
    }
}