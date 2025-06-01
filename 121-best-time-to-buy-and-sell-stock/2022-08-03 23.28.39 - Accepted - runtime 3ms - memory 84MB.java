class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        int len = prices.length, diff=0;
        for(int i=0; i<len; i++) {
            int curr = prices[i];
            if(min>curr) {
                min=curr;
                max=-1;
            }
            if(max<curr){
                max=curr;
                diff = Math.max(diff, (max-min));
            }
        }
        return diff;
    }
}