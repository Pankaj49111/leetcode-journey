class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            if(canEatInTime(piles, mid) <= h) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    public int canEatInTime(int piles[], int k){
        int hours = 0;
        for(int pile : piles){
            int div = pile / k;
            hours += div;
            if(pile % k != 0) hours++;
        }
        return hours;
    }
}