class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> larr = new ArrayList<>();
        List<Integer> garr = new ArrayList<>();
        List<Integer> earr = new ArrayList<>();
        for(int num : nums){
            if(pivot > num) larr.add(num);
            else if(pivot < num) garr.add(num);
            else earr.add(num);
        }

        return Stream.concat(Stream.concat(larr.stream(),earr.stream()),garr.stream())
        .mapToInt(a -> (int) a).toArray();
    }
}