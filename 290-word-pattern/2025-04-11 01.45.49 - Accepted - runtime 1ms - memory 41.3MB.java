class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if(pattern.length() != strs.length) return false;

        HashMap<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(int i=0; i<pattern.length(); i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(strs[i])) return false;
            } else {
                if(set.contains(strs[i])) return false;

                map.put(pattern.charAt(i), strs[i]);
                set.add(strs[i]);
            }
        }
        return true;
    }
}