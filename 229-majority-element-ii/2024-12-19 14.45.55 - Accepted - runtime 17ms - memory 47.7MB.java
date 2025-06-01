class Solution {
    public List<Integer> majorityElement(int[] nums) {
        return Arrays.stream(nums).boxed()
        .collect(Collectors.groupingBy(a -> a, Collectors.counting()))
        .entrySet().stream()
        .filter(a -> a.getValue()>nums.length/3)
        .map(a->a.getKey()).toList();
    }
}