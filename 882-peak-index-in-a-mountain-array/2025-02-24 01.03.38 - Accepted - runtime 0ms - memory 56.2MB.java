class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l=1, r=arr.length-2;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }else if(arr[mid] < arr[mid-1]){
                r = mid-1;
            }else if(arr[mid] < arr[mid+1]){
                l = mid+1;
            }
        }
        return -1;
    }
}