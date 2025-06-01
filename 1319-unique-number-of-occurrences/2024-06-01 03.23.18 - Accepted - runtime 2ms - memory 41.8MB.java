class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        Set<Integer> uniqueSet = new HashSet<>();

        for(Integer val : map.values()){
            if(!uniqueSet.add(val)){
                return false;
            }
        }
        return true;
    }
}