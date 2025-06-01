class Solution {
    public int[] twoSum(int[] num, int target) {
        int n = num.length;
        int l = 0, r = n-1;
        while(l<r){
            int total = num[l] + num[r];
            if(target == total){
                return new int[]{l+1, r+1};
            } else if(total > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{-1, -1};
    }
}