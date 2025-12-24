class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int n = nums.size();
        int i=0, j=n-1;

        int count=0;
        while(i<j){
            if(nums.get(i) + nums.get(j) < target) {
                count += j-i;
                i++;
            }else {
                j--;
            }
        }
        return count;
    }
}