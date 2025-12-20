class Solution {
    public int minDeletionSize(String[] strs) {
        int m=strs.length, n=strs[0].length();
        int count=0;

        for(int c=0; c<n; c++){
            for(int r=1; r<m; r++){
                if(strs[r].charAt(c) < strs[r-1].charAt(c)){
                    count++; break;
                }
            }
        }
        return count;
    }
}