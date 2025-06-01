class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums).boxed()
            .collect(Collectors.groupingBy(a->a, Collectors.counting()));

        for(long num: map.values()){
            if(num%2 != 0) return false;
        }
        return true;
    }
}