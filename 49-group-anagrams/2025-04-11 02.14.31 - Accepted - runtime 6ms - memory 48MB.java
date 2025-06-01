class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> strings = map.containsKey(key) ? map.get(key) : new ArrayList<>();
            strings.add(str);
            map.put(key, strings);
        }
        return new ArrayList<>(map.values());
    }
}