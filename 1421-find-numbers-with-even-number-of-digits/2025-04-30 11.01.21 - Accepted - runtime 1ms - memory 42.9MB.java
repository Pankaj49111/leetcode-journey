class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num: nums){
            
            int cnt=0;
            while(num != 0){
                cnt++;
                num /= 10;
            }
            if(cnt%2 == 0) count++;
        }
        return count;
    }
}