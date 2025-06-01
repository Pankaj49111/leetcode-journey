class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flowerbedSize = flowerbed.length;
        for (int i = 0; i < flowerbedSize; i++) {
            // Check if the current plot is empty
            if (flowerbed[i] == 0) {
                // Check the adjacent plots: previous and next
                boolean prevEmpty = (i == 0 || flowerbed[i - 1] == 0); // First plot or previous plot is empty
                boolean nextEmpty = (i == flowerbedSize - 1 || flowerbed[i + 1] == 0); // Last plot or next plot is empty

                // If both adjacent plots are empty (or out of bounds), we can plant a flower here
                if (prevEmpty && nextEmpty) {
                    flowerbed[i] = 1; // Plant a flower here
                    n--;
                }
            }
        }
        
        // If we finish the loop and haven't planted enough flowers, return false
        return n<=0;
    }
}