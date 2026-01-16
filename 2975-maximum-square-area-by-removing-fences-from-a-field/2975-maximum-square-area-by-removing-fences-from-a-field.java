class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int MOD = 1_000_000_007;

        List<Integer> h = new ArrayList<>();
        h.add(1);
        h.add(m);
        for (int x : hFences) h.add(x);

        List<Integer> v = new ArrayList<>();
        v.add(1);
        v.add(n);
        for (int x : vFences) v.add(x);

        Collections.sort(h);
        Collections.sort(v);

        Set<Integer> horizontalDiffs = new HashSet<>();
        Set<Integer> verticalDiffs = new HashSet<>();

        for (int i = 0; i < h.size(); i++) {
            for (int j = i + 1; j < h.size(); j++) {
                horizontalDiffs.add(h.get(j) - h.get(i));
            }
        }

        for (int i = 0; i < v.size(); i++) {
            for (int j = i + 1; j < v.size(); j++) {
                verticalDiffs.add(v.get(j) - v.get(i));
            }
        }

        long maxSide = -1;
        for (int d : horizontalDiffs) {
            if (verticalDiffs.contains(d)) {
                maxSide = Math.max(maxSide, d);
            }
        }

        return maxSide != -1l ? (int)((maxSide*maxSide)%MOD) : -1;
    }
}