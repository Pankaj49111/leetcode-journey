class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(set.contains(ch)) {
                map.remove(ch);
            } else {
                map.put(ch, i);
                set.add(ch);
            }
        }
        
        return map.size()==0 ? -1 : map.entrySet().iterator().next().getValue();
    }
}