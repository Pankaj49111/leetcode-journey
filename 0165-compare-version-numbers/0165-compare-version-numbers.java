class Solution {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int length1 = split1.length;
        int length2 = split2.length;
        
        int maxLength = Math.max(length1, length2);

        for (int i = 0; i < maxLength; i++) {
            int v1 = (i < length1) ? Integer.parseInt(split1[i]) : 0;
            int v2 = (i < length2) ? Integer.parseInt(split2[i]) : 0;

            if (v1 < v2) return -1;
            if (v1 > v2) return 1;
        }
        return 0;
    }
}
