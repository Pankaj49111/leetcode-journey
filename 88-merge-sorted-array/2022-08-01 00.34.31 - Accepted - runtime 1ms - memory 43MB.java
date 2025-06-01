class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j=0, k=m;
        
        while(j<n) {
            nums1[k] = nums2[j];
            k++;j++;
        }
        Arrays.sort(nums1);
    }
}