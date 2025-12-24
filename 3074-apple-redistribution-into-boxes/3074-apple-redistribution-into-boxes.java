class Solution {
    public int minimumBoxes(int[] apple, int[] caps) {
        int total = 0;
        for(int a :apple) total += a;

        Arrays.sort(caps);
        int m = caps.length;

        int cap = 0, count = 0;
        for(int i = m-1; i>=0; i--){
            cap += caps[i];
            count++;

            if(cap >= total) return count;
        }
        return -1;
    }
}