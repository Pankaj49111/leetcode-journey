class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        backtrack(nums, 0, sub, res);
        return res;
    }

    void backtrack(int[] nums, int idx, List<Integer> sub, List<List<Integer>> res){
        res.add(new ArrayList<>(sub));

        for(int i=idx; i<nums.length; i++){
            sub.add(nums[i]);
            backtrack(nums, i+1, sub, res);
            sub.remove(sub.size()-1);
        }
    }
}