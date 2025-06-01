public class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        return decode(map, s, 0);
    }

    private int decode(Map<Integer, Integer> map, String s, int index) {
        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        if(map.containsKey(index)) return map.get(index);

        int result = decode(map, s, index + 1);

        if (index + 1 < s.length() && 
                s.charAt(index) != '0' && 
                Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            result += decode(map, s, index + 2);
        }

        map.put(index, result);

        return result;
    }
}
