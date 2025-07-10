class Solution {
    class Element {
        int val, row, col;

        Element(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        PriorityQueue<Element> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // Push the first element of each row into the heap
        for (int row = 0; row < Math.min(n, k); row++) {
            minHeap.offer(new Element(matrix[row][0], row, 0));
        }

        // Extract the smallest element k times
        for (int i = 0; i < k - 1; i++) {
            Element e = minHeap.poll();
            if (e.col + 1 < n) {
                minHeap.offer(new Element(matrix[e.row][e.col + 1], e.row, e.col + 1));
            }
        }

        return minHeap.poll().val;
    }
}
