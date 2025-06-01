class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] tripLength = new int[1001];
        for(int[] trip: trips){
            tripLength[trip[1]] += trip[0];
            tripLength[trip[2]] -= trip[0];
        }

        int people = 0;

        for(int i=0; i<1001; i++){
            people += tripLength[i];
            if(people > capacity) return false;
        }
        return true;
    }
}