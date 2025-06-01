class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int i=0,j=0;
        List<Integer> result = new ArrayList<>();

        while(j<nums.length-1){
            while(nums[j] != key && j<nums.length-1){
                j++;
            }
            if(nums[j] != key) break;

            while(Math.abs(i-j) > k){
                i++;
            }

            while(Math.abs(i-j) <= k && i<nums.length){
                result.add(i);
                i++;
            }
            j++;
        }
        return result.size() == 0 ? Arrays.asList(0) : result;
    }
}