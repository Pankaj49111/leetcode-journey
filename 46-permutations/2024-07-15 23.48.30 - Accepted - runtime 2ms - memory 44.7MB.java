class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> ls = new LinkedList<>();
        boolean[] vis = new boolean[nums.length];
        findPerm(nums, ls, ans, vis);
        return ans;
    }

    void findPerm(int[] nums, List<Integer> ls, List<List<Integer>> ans, boolean[] vis) {
        if(ls.size() == nums.length) {
            ans.add(new LinkedList<>(ls));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!vis[i]) {
                vis[i] = true;
                ls.add(nums[i]);
                findPerm(nums, ls, ans, vis);
                ls.remove(ls.size() - 1);
                vis[i] = false;
            }
        }
    }
}