class Solution {
    public int minimumOperations(int[] nums) {
        int n=nums.length;
        Set<Integer> seen = new HashSet<>();

        for(int i=n-1; i>=0; i--){
            if(!seen.add(nums[i])){
                return (i+1)%3 == 0 ? (i+1)/3 : (i+1)/3 + 1;
            }
        }
        return 0;
    }
}