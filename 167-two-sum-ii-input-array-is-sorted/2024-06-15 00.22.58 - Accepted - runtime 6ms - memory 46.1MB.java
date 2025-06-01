class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            if(map.containsKey(target-numbers[i])){
                return new int[]{map.get(target-numbers[i]), i+1};
            } else {
                map.put(numbers[i], i+1);
            }
        }
        return null;
    }
}