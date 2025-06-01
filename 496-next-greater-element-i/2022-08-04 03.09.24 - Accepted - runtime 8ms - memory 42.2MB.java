class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        boolean found = false;
        int i=0;
        for(int num1 : nums1) {
            for(int num2 : nums2) {
                
                if(num2==num1) {
                    found=true;
                }
                
                if(num2>num1 && found==true) {
                    result[i] = num2;
                    found=false;
                    i++;
                    break;
                }
            }
            if(found==true) {
                result[i] = -1;
                i++;
            }
            found = false;
        }
        return result;
    }
}