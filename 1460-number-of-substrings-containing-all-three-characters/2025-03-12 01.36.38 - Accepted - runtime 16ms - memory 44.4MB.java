class Solution {
    public int numberOfSubstrings(String s) {
        int cnt=0, lt=0;
        int len = s.length();
        int[] charCnt = new int[3];
        for(int rt=0; rt<len; rt++){
            charCnt[s.charAt(rt) - 'a']++;

            while(charCnt[0] > 0 && charCnt[1] > 0 && charCnt[2] > 0){
                cnt += len - rt;
                charCnt[s.charAt(lt) - 'a']--;
                lt++;
            }
        }
        return cnt;
    }
}