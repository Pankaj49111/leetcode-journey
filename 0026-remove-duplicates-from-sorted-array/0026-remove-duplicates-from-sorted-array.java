class Solution {
    public int removeDuplicates(int[] a) {
        int k=1;

        for(int i=1; i<a.length; i++){
            if(a[i] != a[k-1]){
                a[k++] = a[i];
            }
        }
        return k;
    }
}