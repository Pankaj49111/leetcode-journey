class Pair{
    int f;
    int s;

    public Pair(int f, int s){
        this.f = f;
        this.s = s;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] ans = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j));
                } else {
                    ans[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            Pair pair = q.poll();
            int row = pair.f;
            int col = pair.s;
            
            if(isValid(row, col+1, n, m) && ans[row][col+1] == -1){
                q.offer(new Pair(row, col+1));
                ans[row][col+1] = ans[row][col] + 1;
            }
            
            if(isValid(row, col-1, n, m) && ans[row][col-1] == -1){
                q.offer(new Pair(row, col-1));
                ans[row][col-1] = ans[row][col] + 1;
            }
            
            if(isValid(row+1, col, n, m) && ans[row+1][col] == -1){
                q.offer(new Pair(row+1, col));
                ans[row+1][col] = ans[row][col] + 1;
            }
            
            if(isValid(row-1, col, n, m) && ans[row-1][col] == -1){
                q.offer(new Pair(row-1, col));
                ans[row-1][col] = ans[row][col] + 1;
            }
        }
        return ans;
    }

    public boolean isValid(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }
        return true;
    }
}