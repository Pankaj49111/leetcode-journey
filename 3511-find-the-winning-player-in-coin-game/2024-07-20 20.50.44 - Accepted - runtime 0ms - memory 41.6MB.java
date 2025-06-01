class Solution {
    public String losingPlayer(int x, int y) {
        int cnt = 0;
        while (x >= 0 && y >= 0) {
            if (cnt % 2 == 0) {
                if (x >= 1 && y >= 4) {
                    x--;
                    y -= 4;
                } else {
                    break;
                }
            } else {
                if (x >= 1 && y >= 4) {
                    x--;
                    y -= 4;
                } else {
                    break;
                }
            }
            cnt++;
        }
        return cnt % 2 == 0 ? "Bob" : "Alice";
    }
}