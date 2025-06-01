class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count=0;
        for(char stone: stones.toCharArray()){
            if(jewels.contains(""+stone)) count++;
        }
        return count;
    }
}