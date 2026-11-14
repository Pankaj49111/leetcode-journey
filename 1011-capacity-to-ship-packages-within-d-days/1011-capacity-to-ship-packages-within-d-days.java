class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        for(int wt: weights){
            low = Math.max(low, wt);
            high += wt;
        }

        while(low < high){
            int mid = low + (high-low)/2;

            if(canShip(weights, days, mid)){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    boolean canShip(int[] wts, int days, int cap){
        int reqdays = 1, currLoad = 0;

        for(int wt: wts){
            if(currLoad + wt > cap){
                reqdays++;
                currLoad = 0;
            }
            currLoad += wt;
        }
        return reqdays <= days;
    }
}