class Solution {
    public boolean canAliceWin(int n) {
        if(n < 10) return false;
        int[] arr = {10, 19, 27, 34, 40, 45, 49, 52, 54, 55};

        for(int i=0; i<arr.length; i++){
            if(n < arr[i]){
                return (i-1)%2 == 0;
            }
        }
        return false;
    }
}