class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        PriorityQueue<KeyPress> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                if (b.duration != a.duration) {
                    return b.duration - a.duration;
                } else {
                    return b.key - a.key;
                }
            }
        );

        maxHeap.offer(new KeyPress(keysPressed.charAt(0), releaseTimes[0]));

        for (int i = 1; i < keysPressed.length(); i++) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            char key = keysPressed.charAt(i);
            maxHeap.offer(new KeyPress(key, duration));
        }

        return maxHeap.peek().key;
    }

    private static class KeyPress {
        char key;
        int duration;

        KeyPress(char key, int duration) {
            this.key = key;
            this.duration = duration;
        }
    }
}
