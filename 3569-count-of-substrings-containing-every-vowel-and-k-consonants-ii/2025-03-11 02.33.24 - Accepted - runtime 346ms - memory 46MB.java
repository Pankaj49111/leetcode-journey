class Solution {
    public long countOfSubstrings(String word, int k) {
        return atLeastK(word, k) - atLeastK(word, k + 1);
    }

    boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }

    long atLeastK(String word, int k){
        int n = word.length();
        int cons=0, i=0;
        long ans=0;

        Map<Character, Integer> map = new HashMap<>();
        for(int j=0; j<n; j++){
            char ch = word.charAt(j);
            if(isVowel(ch)){
                map.put(ch, map.getOrDefault(ch, 0)+1);
            } else {
                cons++;
            }
            while(map.size() == 5 && cons >= k){
                ans += n-j;
                char left = word.charAt(i);
                if(isVowel(left)){
                    map.put(left, map.get(left)-1);
                    if(map.get(left) == 0){
                        map.remove(left);
                    }
                } else {
                    cons--;
                }
                i++;
            }
        }
        return ans;
    }
}