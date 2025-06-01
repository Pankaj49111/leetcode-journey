class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
        List<Integer> list = new ArrayList<>();
        for(int ele : nums1){
            arr[ele]++;
        }
        for(int ele : nums2){
            if(arr[ele]>0){
                list.add(ele);
                arr[ele]--;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}