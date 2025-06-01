class Solution {
    public int subsetXORSum(int[] nums) {
        if(nums.length == 0) return 0;
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);

        int xors = 0;
        for(List<Integer> ls: res){
            int f = ls.get(0);
            for(int i=1; i<ls.size(); i++){
                f ^= ls.get(i);
            }
            xors += f;
        }
        return xors;
    }
    void backtrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> res){
        if(!curr.isEmpty()) res.add(new ArrayList<>(curr));

        for(int i=start; i<nums.length; i++){
            curr.add(nums[i]);
            backtrack(nums, i+1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}