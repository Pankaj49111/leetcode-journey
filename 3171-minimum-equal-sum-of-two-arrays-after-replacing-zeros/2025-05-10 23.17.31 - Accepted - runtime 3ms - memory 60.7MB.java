class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1=0, sum2=0;
        int z1=0, z2=0;

        for(int num: nums1){
            if(num == 0) z1++;
            sum1 += num;
        }
        for(int num: nums2){
            if(num == 0) z2++;
            sum2 += num;
        }

        if(z1 == 0 && z2 == 0){
            return sum1 == sum2 ? sum1 : -1;
        }

        long minAdd1 = z1;
        long minAdd2 = z2;

        long low1 = sum1 + minAdd1;
        long low2 = sum2 + minAdd2;

        if (low1 > low2 && z2 == 0) return -1;
        if (low2 > low1 && z1 == 0) return -1;

        long target = Math.max(low1, low2);
        return target;
    }
}