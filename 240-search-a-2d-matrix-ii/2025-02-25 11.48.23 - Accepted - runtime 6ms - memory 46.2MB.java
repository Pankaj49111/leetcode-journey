class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int n=mat.length, m = mat[0].length;

        for(int i=0; i<n; i++){
            if(search(mat[i], target)) return true;
        }
        return false;
    }

    boolean search(int[] arr, int target){
        int l = 0, r = arr.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid] == target){
                return true;
            } else if(arr[mid] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return false;
    }
}