class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] memo = new Integer[n][n];
        return dfs(triangle, 0, 0, memo);
    }

    int dfs(List<List<Integer>> ls, int idx, int row, Integer[][] memo){
        if(row == ls.size()-1) return ls.get(row).get(idx);

        if(memo[row][idx] != null) return memo[row][idx];

        int down = dfs(ls, idx, row+1, memo);
        int diag = dfs(ls, idx+1, row+1, memo);

        memo[row][idx] = ls.get(row).get(idx) + Math.min(down, diag);
        return memo[row][idx];
    }
}