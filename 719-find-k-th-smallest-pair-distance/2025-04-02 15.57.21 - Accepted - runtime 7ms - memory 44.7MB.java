class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0; 
        int right = nums[nums.length-1]-nums[0]; // distance between any two elements in the array can never exceed the difference between the largest and smallest element
        
        while(left < right){
            int mid = left + (right - left) / 2;
            if(countPairs(nums, mid) < k){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    int countPairs(int[] nums, int dist){
        int count = 0, i = 0;

        for(int j=1; j<nums.length; j++){
            while(nums[j] - nums[i] > dist){
                i++;
            }
            count += j-i;
        }
        return count;
    }
}