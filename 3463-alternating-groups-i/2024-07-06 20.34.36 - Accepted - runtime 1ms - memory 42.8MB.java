class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        if(n < 3) return 0;

        int count = 0;
        for(int i = 0; i < n; i++){
            int first = colors[(i+n-1)%n];
            int sec = colors[i];
            int third = colors[(i+1)%n];
            if((first != sec) && (sec != third)){
                count++;
            }
        }
        return count;
    }
}