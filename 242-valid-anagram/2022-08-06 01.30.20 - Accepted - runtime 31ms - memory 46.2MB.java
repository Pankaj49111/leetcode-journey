class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int cntExtra = 0;
        for(char ch : t.toCharArray()) {
            if(map.containsKey(ch)){
                if(map.get(ch)>0){
                    map.put(ch, map.get(ch)-1);
                    if(map.get(ch)==0){
                        map.remove(ch);
                    }
                }
            } else {
                cntExtra++;
            }
        }
        return (map.size()==0 && cntExtra==0);
    }
}