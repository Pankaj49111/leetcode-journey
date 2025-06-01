class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, max = 0;

        for(int i=1; i<=n; i++){
            int sum = String.valueOf(i).chars()
                        .mapToObj(c -> (char) c).mapToInt(Character::getNumericValue).sum();

            map.put(sum, map.getOrDefault(sum, 0) + 1);
            max = Math.max(max, map.get(sum));
        }

        for (int val : map.values()) if(val == max) count++;
        return count;
    }
}