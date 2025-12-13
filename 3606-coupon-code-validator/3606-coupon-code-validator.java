class Solution {
    private static final Map<String, Integer> ORDER = Map.of(
        "electronics", 0,
        "grocery", 1,
        "pharmacy", 2,
        "restaurant", 3
    );

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Coupon> validCoupons = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (!isActive[i]) continue;
            if (!ORDER.containsKey(businessLine[i])) continue;
            if (!isValidCode(code[i])) continue;

            validCoupons.add(new Coupon(code[i], businessLine[i]));
        }

        // Sort by businessLine order, then by code
        validCoupons.sort((a, b) -> {
            int cmp = Integer.compare(
                ORDER.get(a.businessLine),
                ORDER.get(b.businessLine)
            );
            if (cmp != 0) return cmp;
            return a.code.compareTo(b.code);
        });

        // Extract codes
        List<String> result = new ArrayList<>();
        for (Coupon c : validCoupons) {
            result.add(c.code);
        }
        return result;
    }

    private boolean isValidCode(String s) {
        if (s == null || s.isEmpty()) return false;
        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }

    static class Coupon {
        String code;
        String businessLine;

        Coupon(String code, String businessLine) {
            this.code = code;
            this.businessLine = businessLine;
        }
    }
}
