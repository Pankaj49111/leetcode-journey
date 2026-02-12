class Solution {
    public int maxArea(int[] ht) {
        int n=ht.length;
        int i=0, j=n-1;
        int maxAr=0;
        while(i<j){
            int minHt = Math.min(ht[i], ht[j]);
            maxAr = Math.max(maxAr, minHt*(j-i));

            while(i<j && ht[i] <= minHt) i++;
            while(i<j && ht[j] <= minHt) j--;
        }
        return maxAr;
    }
}