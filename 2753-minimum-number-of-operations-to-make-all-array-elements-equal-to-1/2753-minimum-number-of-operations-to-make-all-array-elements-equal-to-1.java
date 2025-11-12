class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int totGcd = nums[0], ones=0;
        for(int x: nums){
            totGcd = gcd(totGcd, x);
            if(x==1) ones++;
        }

        if(totGcd != 1) return -1;
        if(ones > 0) return n-ones;

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int g = nums[i];
            for(int j=i; j<n; j++){
                g = gcd(g, nums[j]);
                if(g == 1){
                    min = Math.min(min, j-i+1);
                    break;
                }
            }
        }
        return (min-1)+(n-1);
    }

    int gcd(int a, int b){
        return b==0 ? a : gcd(b, a%b);
    }
}