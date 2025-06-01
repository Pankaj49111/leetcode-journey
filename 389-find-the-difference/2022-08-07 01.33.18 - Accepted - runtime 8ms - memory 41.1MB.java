class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char ch : s.toCharArray()) map.put(ch, map.getOrDefault(ch,0)+1);
        
        for(char c : t.toCharArray()){
            if(map.containsKey(c) && map.get(c) == 0 || !map.containsKey(c)) return c;
            else map.put(c, map.get(c) - 1);
        }
        return '!';
    }
}