class Solution {
    public int longestOnes(int[] nums, int k) {
        int start=0, end=0, count=0;
        for(end = 0; end < nums.length; end++){
            if(nums[end] == 0){   
                count++;
            }
            if(count > k){
                if(nums[start] == 0){   
                    count--;
                }
                start++;
            }
        }
        return end-start;
    }
}