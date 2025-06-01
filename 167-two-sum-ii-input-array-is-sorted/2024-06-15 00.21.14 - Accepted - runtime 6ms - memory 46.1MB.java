class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int n = numbers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            if(map.containsKey(target-numbers[i])){
                result[0] = map.get(target-numbers[i]);
                result[1] = i+1;
                return result;
            } else {
                map.put(numbers[i], i+1);
            }
        }
        return null;
    }
}