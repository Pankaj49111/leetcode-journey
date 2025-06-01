class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> distinctInNums1 = new ArrayList<>();
        List<Integer> distinctInNums2 = new ArrayList<>();

        for (int num : nums1) {
            if (set.add(num)) {
                distinctInNums1.add(num);
            }
        }
        for (int num : nums2) {
            if (set.add(num)) {
                distinctInNums2.add(num);
            } else {
                distinctInNums1.remove(Integer.valueOf(num));
            }
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(distinctInNums1);
        answer.add(distinctInNums2);

        return answer;
    }
}