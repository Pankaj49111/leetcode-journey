class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0)+1);
        }
        for(int i=0; i<nums1.length; i++){
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0)+1);
        }
        
        for(int i=0; i<nums1.length; i++){
            if(map2.containsKey(nums1[i])){
                map1.remove(nums1[i]);
                map2.remove(nums1[i]);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(map1.keySet()));res.add(new ArrayList<>(map2.keySet()));
        return res;
    }
}