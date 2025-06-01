class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for (String query : queries) {
            result.add(matches(query, pattern));
        }
        return result;
    }

    boolean matches(String query, String pattern) {
        int i = 0; // pointer for pattern

        for (int j = 0; j < query.length(); j++) {
            char qc = query.charAt(j);
            // Match pattern character
            if (i < pattern.length() && qc == pattern.charAt(i)) {
                i++;
            } else if (Character.isUpperCase(qc)) {
                // Uppercase letter in query that doesn't match pattern
                return false;
            }
            // else: it's a lowercase char not in pattern, skip it
        }

        return i == pattern.length(); // All of pattern was matched
    }
}
