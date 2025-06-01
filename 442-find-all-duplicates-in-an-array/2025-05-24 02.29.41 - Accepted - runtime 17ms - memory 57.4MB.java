class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for(int num: nums){
            if(!seen.add(num)) res.add(num);
        }
        return res;
    }
}