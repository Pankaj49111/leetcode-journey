class Solution {
    // catalan number problem
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n, res);
        return res;
    }

    private void backtrack(StringBuilder sb, int open, int close, int max, List<String> res) {
        if (sb.length() == max * 2) {
            res.add(sb.toString());
            return;
        }

        if (open < max) {
            sb.append('(');
            backtrack(sb, open + 1, close, max, res);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }

        if (close < open) {
            sb.append(')');
            backtrack(sb, open, close + 1, max, res);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
    }
}
