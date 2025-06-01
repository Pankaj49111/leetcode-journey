class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int j=0, count=0;
        while(j<arr.length){
            if(arr[j]%2 != 0){
                j++;
                count++;
                if(count == 3) return true;
            } else {
                j++;
                count=0;
            }
        }
        return false;
    }
}