class Solution {
    public int minCost(String colors, int[] neededTime) {
        int count=0;
        if(colors.length() == 1) return count;

        char[] ch = colors.toCharArray();
        for(int i=1; i<ch.length; i++){
            if(ch[i] == ch[i-1]){
                count += Math.min(neededTime[i], neededTime[i-1]);

                neededTime[i] = Math.max(neededTime[i], neededTime[i-1]);
            }
        }
        return count;
    }
}