class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int[] gain = new int[gas.length];

        for(int i = 0; i < length;i++) {
            gain[i] = gas[i] - cost[i];
        }

        int start = 0;

        int current = 0;
        int total = 0;

        for(int i = 0; i < length;i++) {
            current += gain[i];
            total += gain[i];

            if (current < 0) {
                start = i + 1;
                current = 0;
            }
        }

        return total >= 0 ? start : -1;   
    }
}