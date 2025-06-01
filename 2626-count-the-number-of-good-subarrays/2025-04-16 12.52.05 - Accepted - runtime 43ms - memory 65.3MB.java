class Solution {
    public long countGood(int[] a, int k) {
        int n = a.length;
        int l = 0, r = 0;
        long curr = 0;
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(r < n){
            if(map.containsKey(a[r])) {
                curr += map.get(a[r]);
            }
            map.put(a[r], map.getOrDefault(a[r], 0) + 1);

            while(curr >= k){
                if(map.get(a[l]) == 1) map.remove(a[l]);
                else{
                    curr -= map.get(a[l]) - 1;
                    map.put(a[l], map.get(a[l]) - 1);
                }
                l++;
            }

            ans += (l);
            ++r;
        }

        return ans;
    }
}