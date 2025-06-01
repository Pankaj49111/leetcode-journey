class Solution {
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        int zeros = 0;
        for(int num: arr){
            if(num == 0) zeros++;
        }

        int lastIdx = len-1;
        int newIdx = len-1+zeros;

        while(lastIdx >= 0){
            if(newIdx < len){
                arr[newIdx] = arr[lastIdx];
            }
            if(arr[lastIdx] == 0){
                newIdx--;
                if(newIdx < len){
                    arr[newIdx] = 0;
                }
            }
            lastIdx--;
            newIdx--;
        }
    }
}