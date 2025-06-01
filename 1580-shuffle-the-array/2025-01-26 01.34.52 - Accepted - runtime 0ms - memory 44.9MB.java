class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];

        int i=0, j=n, cnt=0;
        while(j<2*n){
            res[cnt++] = nums[i++];
            res[cnt++] = nums[j++];
        }
        return res;
    }
}