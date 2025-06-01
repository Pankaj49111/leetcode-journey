class Solution {
    public int differenceOfSums(int n, int m) {
        int sd = 0, snd = 0;
        for(int i = 1; i <= n; i++){
            if(i % m == 0) sd += i;
            else snd += i;
        }
        return (snd-sd);
    }
}