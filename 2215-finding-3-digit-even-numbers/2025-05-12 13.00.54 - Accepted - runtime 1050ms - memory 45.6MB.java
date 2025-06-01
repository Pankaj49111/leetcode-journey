public class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> resultSet = new HashSet<>();
        boolean[] used = new boolean[digits.length];
        backtrack(digits, used, new ArrayList<>(), resultSet);
        
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }
        Arrays.sort(result);
        return result;
    }

    void backtrack(int[] digits, boolean[] used, List<Integer> path, Set<Integer> result) {
        if (path.size() == 3) {
            int d1 = path.get(0);
            int d2 = path.get(1);
            int d3 = path.get(2);
            if (d1 == 0 || d3 % 2 != 0) return;
            int number = d1 * 100 + d2 * 10 + d3;
            result.add(number);
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(digits[i]);
            backtrack(digits, used, path, result);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
