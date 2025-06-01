class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if(len == 1 && flowerbed[0] == 0) return true;

        if(len >=2 && flowerbed[0] == 0 && flowerbed[1] == 0 && n>0){
            flowerbed[0] = 1;
            n--;
        }

        if(len >= 2 && flowerbed[len-1] == 0 && flowerbed[len-2] == 0 && n>0) {
            flowerbed[len-1] = 1;
            n--;
        }

        for(int i=0; i<len-2; i++){
            if(flowerbed[i] == 0 &&
            flowerbed[i+1] == 0 && 
            flowerbed[i+2] == 0
            ){
                if(n>0){
                    flowerbed[i+1] = 1;
                    n--;
                }
            }
        }

        if(n == 0){
            return true;
        }
        return false;
    }
}