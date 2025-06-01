class Solution {
    public int countCompleteDayPairs(int[] a) {
        int count = 0;
        int n = a.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if((a[i] + a[j]) % 24 == 0){
                    count++;
                }
            }
        }
        return count;
    }
}