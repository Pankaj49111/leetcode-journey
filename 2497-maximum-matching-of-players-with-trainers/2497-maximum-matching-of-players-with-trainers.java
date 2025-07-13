class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int trainer : trainers) {
            minHeap.offer(trainer);
        }

        int matches = 0;

        for (int player : players) {
            // Remove all trainers who can't train this player
            while (!minHeap.isEmpty() && minHeap.peek() < player) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                matches++;
                minHeap.poll(); // assign the smallest trainer that can handle the player
            }
        }

        return matches;
    }
}
