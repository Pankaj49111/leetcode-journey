class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missingCount=0, curr=1, idx=0;

        while(missingCount < k){
            if(idx < arr.length && arr[idx] == curr){
                idx++;
            } else {
                missingCount++;
            }

            if(missingCount == k){
                return curr;
            }
            curr++;
        }
        return -1;
    }
}