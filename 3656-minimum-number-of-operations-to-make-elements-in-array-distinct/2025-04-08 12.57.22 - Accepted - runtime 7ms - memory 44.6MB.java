class Solution {
    int count=0;
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        checkAndRemove(0, 3, map, nums);
        return count;
    }

    void checkAndRemove(int f, int l, Map<Integer, Integer> map, int[] nums){
        boolean isDistinct = checkForDistinct(new ArrayList<>(map.values()));
        if(isDistinct){
            return;
        } else {
            count++;
            for(int i=f; i<Math.min(l, nums.length); i++){
                if(map.containsKey(nums[i])){
                    map.put(nums[i], map.get(nums[i])-1);
                    if(map.get(nums[i]) == 0) map.remove(nums[i]);
                }
            }
            checkAndRemove(l, l+3, map, nums);
        }
    }

    boolean checkForDistinct(List<Integer> list){
        // System.out.println(list);
        for(int i=0; i<list.size(); i++){
            if(list.get(i) > 1) return false;
        }
        return true;
    }
}