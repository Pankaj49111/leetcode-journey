class Solution {
    public int numberOfBeams(String[] bank) {
        int prevCount=0, sum=0;
        for(String b: bank) {
            int currCount=0;
            for(char c: b.toCharArray()){
                if(c == '1') currCount++;
            }
            if(currCount > 0) {
                sum += prevCount*currCount;
                prevCount = currCount;
            }
        }
        return sum;
    }
}