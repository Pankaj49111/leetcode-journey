class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int top = 0, bot = mat.length-1;

        while(top <= bot){
            int mid = (top + bot)/2;
            if(mat[mid][0] < target && mat[mid][mat[mid].length - 1] > target){
                break;
            }else if(mat[mid][0] > target){
                bot = mid-1;
            }else{
                top = mid+1;
            }
        }
        int row = (top+bot)/2;
        int l = 0, r = mat[row].length-1;

        while(l <= r){
            int mid = (l+r)/2;
            if(mat[row][mid] == target){
                return true;
            }else if(mat[row][mid] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return false;
    }
}