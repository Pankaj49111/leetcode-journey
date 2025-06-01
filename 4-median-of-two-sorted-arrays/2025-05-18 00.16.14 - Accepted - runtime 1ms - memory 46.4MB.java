class Solution {
    public double findMedianSortedArrays(int[] n1, int[] n2) {
        int[] nums = new int[n1.length + n2.length];
        int i=0, j=0, k=0;
        while(i<n1.length && j<n2.length){
            if(n1[i] < n2[j]){
                nums[k] = n1[i];
                i++; k++;
            } else {
                nums[k] = n2[j];
                j++; k++;
            }
        }

        while(i<n1.length){
            nums[k] = n1[i];
            i++; k++;
        }

        while(j<n2.length){
            nums[k] = n2[j];
            j++; k++;
        }

        if(nums.length % 2 != 0){
            return nums[nums.length/2];
        } else {
            return (nums[nums.length/2] + nums[nums.length/2 - 1])/2.0;
        }
    }
}