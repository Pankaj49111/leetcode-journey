class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int idx = 0;
        
        for (int x = 1; x <= target[target.length - 1]; x++) {
            ans.add("Push");
            if (x == target[idx]) {
                idx++;
                if (idx == target.length) break;
            } else {
                ans.add("Pop");
            }
        }
        
        return ans;
    }
}
