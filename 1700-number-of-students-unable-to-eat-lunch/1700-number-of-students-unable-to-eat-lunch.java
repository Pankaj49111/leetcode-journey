class Solution {
    public int countStudents(int[] sts, int[] sds) {
        int c0=0, c1=0;
        for(int s: sts) {
            if(s == 0) c0++;
            else c1++;
        }

        for(int s: sds){
            if(s == 0){
                if(c0 == 0) break;
                c0--;
            } else {
                if(c1 == 0) break;
                c1--;
            }
        }
        return c0+c1;
    }
}