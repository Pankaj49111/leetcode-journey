class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color) return image;
        int curr = image[sr][sc];
        dfs(image, color, curr, sr, sc);
        return image;
    }

    void dfs(int[][] image, int color, int curr, int i, int j){
        if(i<0 || j<0 || i>=image.length || j>=image[0].length || image[i][j] != curr) return;

        image[i][j] = color;
        dfs(image, color, curr, i+1, j);
        dfs(image, color, curr, i-1, j);
        dfs(image, color, curr, i, j+1);
        dfs(image, color, curr, i, j-1);
    }
}