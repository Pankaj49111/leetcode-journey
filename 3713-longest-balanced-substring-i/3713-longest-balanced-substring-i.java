class Solution {
    public int longestBalanced(String s) {
        int maxLen = -1;
        int n=s.length();

        for(int i=0; i<n; i++){
            int[] freq = new int[26];
        
            for(int j=i; j<n; j++){
                freq[s.charAt(j) - 'a']++;

                if(balanced(freq)){
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }

    boolean balanced(int[] ar){
        int count=0;
        for(int f: ar){
            if(f>0){
                if(count == 0) count=f;
                else if(f != count) return false;
            }
        }
        return true;
    }
}