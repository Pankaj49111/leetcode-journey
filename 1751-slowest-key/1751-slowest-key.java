class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxDuration = releaseTimes[0];
        char result = keysPressed.charAt(0);

        for (int i = 1; i < keysPressed.length(); i++) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            char key = keysPressed.charAt(i);

            if (duration > maxDuration || (duration == maxDuration && key > result)) {
                maxDuration = duration;
                result = key;
            }
        }

        return result;
    }
}