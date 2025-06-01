class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] nArr = new int[n+1];

        for(int num: citations){
            if(num >= n){
                nArr[n]++;
            } else {
                nArr[num]++;
            }
        }

        int cnt=0;
        for(int i=n; i>=0; i--){
            cnt += nArr[i];
            if(cnt >= i){
                return i;
            }
        }
        return 0;
    }
}