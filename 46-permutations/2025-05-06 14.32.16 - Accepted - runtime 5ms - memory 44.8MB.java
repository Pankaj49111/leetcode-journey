class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, 0, list);
        return list;
    }

    void helper(int[] nums, int idx, List<List<Integer>> list){
        if(idx == nums.length){
            list.add(new ArrayList<>(Arrays.stream(nums).boxed().toList()));
            return;
        }

        for(int i=idx; i<nums.length; i++){
            swap(nums, i, idx);
            helper(nums, idx+1, list);
            swap(nums, i, idx);
        }
    }

    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}