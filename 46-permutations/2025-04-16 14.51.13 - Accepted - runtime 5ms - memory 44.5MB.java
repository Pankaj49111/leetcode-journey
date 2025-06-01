class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res);
        return res;
    }

    void backtrack(int[] nums, int idx, List<List<Integer>> res){

        if(idx == nums.length){
            res.add(new ArrayList<>(Arrays.stream(nums).boxed().toList()));
            return;
        }

        for(int i=idx; i<nums.length; i++){
            swap(nums, i, idx);
            backtrack(nums, idx+1, res);
            swap(nums, i, idx);
        }
    }

    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}