class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums, int idx){
        if(idx == nums.length){
            if(!result.contains(subset)){
                result.add(new ArrayList<>(subset));
            }
            return;
        }

        backtrack(result, subset, nums, idx+1);
        subset.add(nums[idx]);
        backtrack(result, subset, nums, idx+1);
        subset.remove(subset.size()-1);
    }
}