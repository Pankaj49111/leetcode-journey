class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int t=0, b=matrix.length-1;
        while(t<=b){
            int mid = (t+b)/2;
            if(matrix[mid][0] < target && matrix[mid][matrix[mid].length-1] > target){
                break;
            } else if(matrix[mid][0] > target){
                b = mid - 1;
            } else {
                t = mid + 1;
            }
        }

        int row = (t+b)/2;
        int l = 0, r = matrix[row].length-1;

        while(l<=r){
            int mid = (l+r)/2;
            if(matrix[row][mid] == target){
                return true;
            } else if(matrix[row][mid] < target){
                l = mid+1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}