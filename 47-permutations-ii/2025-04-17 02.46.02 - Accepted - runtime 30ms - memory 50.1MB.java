class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res);
        return res.stream().distinct().toList();
    }

    void backtrack(int[] nums, int idx, List<List<Integer>> res){

        if(idx == nums.length){
            res.add(toList(nums));
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

    List<Integer> toList(int[] nums){
        List<Integer> res = new ArrayList<>();
        for(int num: nums) res.add(num);

        return res;
    }
}