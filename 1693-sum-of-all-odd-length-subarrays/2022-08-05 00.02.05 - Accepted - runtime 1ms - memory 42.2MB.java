class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum=0, n=arr.length;
        for(int i=0; i<n; i++) {
            sum += ((n-i)*(i+1) + 1)/2 * arr[i];
        }
        return sum;
    }
}