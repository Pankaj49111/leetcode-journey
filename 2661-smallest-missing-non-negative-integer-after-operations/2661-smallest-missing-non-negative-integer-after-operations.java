class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int x : nums) {
            int mod = ((x % value) + value) % value; // handle negatives
            count.put(mod, count.getOrDefault(mod, 0) + 1);
        }

        int mex = 0;
        while (true) {
            int mod = mex % value;
            if (count.getOrDefault(mod, 0) == 0) break;
            count.put(mod, count.get(mod) - 1);
            mex++;
        }
        return mex;
    }
}
