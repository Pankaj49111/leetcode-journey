class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums, int idx){
        result.add(new ArrayList<>(subset));

        for(int i=idx; i<nums.length; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;

            subset.add(nums[i]);
            backtrack(result, subset, nums, i+1);
            subset.remove(subset.size()-1);
        }
    }
}