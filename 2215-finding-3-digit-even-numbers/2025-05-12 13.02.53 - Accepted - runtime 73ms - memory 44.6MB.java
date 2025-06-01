public class Solution {
    public int[] findEvenNumbers(int[] digits) {
        boolean[] used = new boolean[1000];
        int n = digits.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    int d1 = digits[i], d2 = digits[j], d3 = digits[k];

                    if (d1 == 0 || d3 % 2 != 0) continue;

                    int num = d1 * 100 + d2 * 10 + d3;
                    used[num] = true;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 100; i < 1000; i += 2) {
            if (used[i]) result.add(i);
        }

        int[] resArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArr[i] = result.get(i);
        }
        return resArr;
    }
}
