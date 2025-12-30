class Solution {
    Map<String, Boolean> memo = new HashMap<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String rule : allowed) {
            String key = rule.substring(0, 2);
            map.computeIfAbsent(key, k -> new ArrayList<>())
            .add(rule.charAt(2));
        }

        return dfs(bottom, map);
    }

    boolean dfs(String bottom, Map<String, List<Character>> map) {
        if (bottom.length() == 1) {
            return true;
        }

        if (memo.containsKey(bottom)) {
            return memo.get(bottom);
        }

        boolean result = buildNext(bottom, 0, new StringBuilder(), map);
        memo.put(bottom, result);
        return result;
    }

    boolean buildNext(String bottom, int index, StringBuilder current, Map<String, List<Character>> map) {
        if (index == bottom.length() - 1) {
            return dfs(current.toString(), map);
        }

        String key = bottom.substring(index, index + 2);
        if (!map.containsKey(key)) {
            return false;
        }

        for (char c : map.get(key)) {
            current.append(c);
            if (buildNext(bottom, index + 1, current, map)) {
                return true;
            }
            current.deleteCharAt(current.length() - 1);
        }

        return false;
    }
}