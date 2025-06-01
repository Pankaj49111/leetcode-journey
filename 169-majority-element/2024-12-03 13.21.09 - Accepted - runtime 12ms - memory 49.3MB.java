class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            if(entry.getValue() > nums.length/2) return entry.getKey();
        }
        return -1;
    }
}