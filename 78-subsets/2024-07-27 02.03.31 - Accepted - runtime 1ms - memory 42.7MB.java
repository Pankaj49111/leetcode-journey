class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        addSubset(result, subset, nums, 0);
        return result;
    }

    public void addSubset(List<List<Integer>> result, List<Integer> subset, int[] nums, int idx){
        result.add(new ArrayList<>(subset));

        for(int i=idx; i<nums.length; i++){
            subset.add(nums[i]);
            addSubset(result, subset, nums, i+1);
            subset.remove(subset.size()-1);
        }
    }
}