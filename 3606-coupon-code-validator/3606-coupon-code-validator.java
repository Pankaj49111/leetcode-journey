class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> valid = Arrays.asList("electronics", "grocery", "pharmacy", "restaurant");

        // store businessLine + code together
        List<String[]> res = new ArrayList<>();
        int n = code.length;

        for (int i = 0; i < n; i++) {
            if (!isActive[i]) continue;

            String business = businessLine[i];
            if (!valid.contains(business)) continue;

            String cd = code[i];
            if (!isValid(cd)) continue;

            res.add(new String[]{business, cd});
        }

        // sort by businessLine order, then by code
        res.sort((a, b) -> {
            int cmp = valid.indexOf(a[0]) - valid.indexOf(b[0]);
            if (cmp != 0) return cmp;
            return a[1].compareTo(b[1]);
        });

        // extract only codes
        List<String> ans = new ArrayList<>();
        for (String[] pair : res) {
            ans.add(pair[1]);
        }

        return ans;
    }

    boolean isValid(String s) {
        return s != null && s.matches("[A-Za-z0-9_]+");
    }
}
