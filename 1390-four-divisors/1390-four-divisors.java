class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum=0;
        for(int n: nums){
            int sum = 0, count= 0;
            for(int i=1; i*i<=n; i++) {
                if(n%i == 0){
                    sum += i; count++;
                    if(i != n/i) {
                        sum += n/i; count++;
                    }
                }
                if(count > 4) break;
            }
            if(count == 4){
                totalSum += sum;
            }
        }
        return totalSum;
    }
}