class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new TreeSet<>();

        for(int num: nums){
            set.add(num);
        }
        
        List<Integer> ls = new ArrayList<>(set);
        int len = ls.size();
        if(len <= 1) return len;

        int count = 1, max = 0;
        for(int i=1; i<len; i++){
            if(ls.get(i-1) + 1 == ls.get(i)) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);

        }
        return max;
    }
}