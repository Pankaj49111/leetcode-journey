class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length;

        while(l < r){
            int mid = l + (r-l)/2;

            int missEle = arr[mid] - (mid + 1);

            if(missEle < k){
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l + k;
    }
}