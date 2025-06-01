class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int[] n1: nums1){
            map.put(n1[0], n1[1]);
        }

        for(int[] n2: nums2){
            if(map.containsKey(n2[0])){
                map.put(n2[0], map.get(n2[0])+n2[1]);
            } else {
                map.put(n2[0], n2[1]);
            }
        }

        int[][] array = new int[map.size()][2];
        int idx=0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            array[idx][0] = entry.getKey(); 
            array[idx][1] = entry.getValue();
            idx++;
        }
        return array;
    }
}