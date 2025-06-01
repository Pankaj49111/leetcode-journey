class Solution {
    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for(String word: words){
            int[] curr = new int[26];

            for(char c: word.toCharArray()){
                curr[c-'a']++;
            }

            for(int i=0; i<26; i++){
                minFreq[i] = Math.min(minFreq[i], curr[i]);
            }
        }

        for(int i=0; i<26; i++){
            while(minFreq[i] > 0){
                res.add(String.valueOf((char)('a'+i)));
                minFreq[i]--;
            }
        }
        return res;
    }
}