class Solution {
    public int maximumCount(int[] nums) {
        int pos = nums.length - binaryPos(nums);
        int neg = binaryNeg(nums);
        return Math.max(pos, neg);
    }

    int binaryPos(int[] nums){
        int l=0, h=nums.length -1;

        while(l<=h){
            int mid = l + (h-l)/2;

            if(nums[mid] > 0){
                h = mid-1;
            } else {
                l = mid+1;
            }
        }
        // System.out.println(l);
        return l;
    }

    int binaryNeg(int[] nums){
        int l=0, h=nums.length -1;

        while(l<=h){
            int mid = l + (h-l)/2;

            if(nums[mid] < 0){
                l = mid+1;
            } else {
                 h= mid-1;
            }
        }
        // System.out.println(h+1);
        return h+1;
    }
}