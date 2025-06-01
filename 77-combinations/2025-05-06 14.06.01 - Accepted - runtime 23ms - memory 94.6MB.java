class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), list);
        return list;
    }

    void backtrack(int n, int k, int idx, List<Integer> comb, List<List<Integer>> list){
        if(comb.size() == k) {
            list.add(new ArrayList<>(comb));
            return;
        }

        for(int i=idx; i<=n; i++){
            comb.add(i);
            backtrack(n, k, i+1, comb, list);
            comb.remove(comb.size()-1);
        }
    }
}