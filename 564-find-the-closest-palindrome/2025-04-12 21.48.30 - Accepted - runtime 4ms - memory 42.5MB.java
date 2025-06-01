class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n);
        Set<Long> candidates = new HashSet<>();

        candidates.add((long)Math.pow(10, len) + 1);
        candidates.add((long)Math.pow(10, len - 1) - 1);

        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));

        for (long i = prefix - 1; i <= prefix + 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);

            String candidateStr;
            if (len % 2 == 0) {
                candidateStr = sb.toString() + new StringBuilder(sb).reverse().toString();
            } else {
                candidateStr = sb.toString() + new StringBuilder(sb.substring(0, sb.length() - 1)).reverse().toString();
            }

            candidates.add(Long.parseLong(candidateStr));
        }

        long closest = -1;
        for (long cand : candidates) {
            if (cand == num) continue;
            if (closest == -1 ||
                Math.abs(cand - num) < Math.abs(closest - num) ||
                (Math.abs(cand - num) == Math.abs(closest - num) && cand < closest)) {
                closest = cand;
            }
        }

        return String.valueOf(closest);
    }
}