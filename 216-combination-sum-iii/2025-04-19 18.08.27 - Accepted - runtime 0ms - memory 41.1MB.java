class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<>(), k, n, 1);
        return list;
    }

    void helper(List<List<Integer>> list, List<Integer> res, int k, int n, int idx){
        if(k == 0 && n == 0){
            list.add(new ArrayList<>(res));
            return;
        }

        for(int i=idx; i <= 9; i++){
            if(i > n) break;

            res.add(i);
            helper(list, res, k-1, n-i, i+1);
            res.remove(res.size()-1);
        }
    }
}