class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return climbStairs(n, map);
    }
    public int climbStairs(int n, Map<Integer, Integer> map) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if(!map.containsKey(n)){
            map.put(n, climbStairs(n-1, map)+climbStairs(n-2, map));
        }
        return map.get(n);
    }
}