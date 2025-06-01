/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int peak = findPeak(arr);
        int res = search(arr, 0, peak, target, true);
        if(res != -1) return res;
        return search(arr, peak+1, arr.length()-1, target, false);
    }

    public int findPeak(MountainArray arr){
        int l = 1, r = arr.length()-2;

        while(l<=r){
            int mid = l + (r-l)/2;

            if(arr.get(mid) > arr.get(mid-1) && arr.get(mid) > arr.get(mid+1)){
                return mid;
            } else if(arr.get(mid) < arr.get(mid-1)){
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }
    public int search(MountainArray arr, int l, int r, int target, boolean isAsc){
        while(l<=r){
            int mid = l + (r-l)/2;
            int midVal = arr.get(mid);
            
            if(midVal == target){
                return mid;
            } else if(midVal > target){
                if(isAsc) r = mid - 1;
                else l = mid + 1;
            } else {
                if(isAsc) l = mid+1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}