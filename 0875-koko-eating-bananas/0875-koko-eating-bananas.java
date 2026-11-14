class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for(int p: piles) {
            high = Math.max(p, high);
        }

        while(low<high){
            int mid = low + (high-low)/2;
            if(canFinish(piles, h, mid)){
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    boolean canFinish(int[] piles, int h, int k){
        int hours = 0;

        for(int p: piles){
            hours += (p+k-1)/k;

            if(hours > h){
                return false;
            }
        }
        return true;
    }
}