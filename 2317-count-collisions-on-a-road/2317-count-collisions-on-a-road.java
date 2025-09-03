class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int left = 0, right = n - 1;

        // Skip escaping left movers
        while (left < n && directions.charAt(left) == 'L') {
            left++;
        }

        // Skip escaping right movers
        while (right >= 0 && directions.charAt(right) == 'R') {
            right--;
        }

        int collisions = 0;
        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') {
                collisions++;
            }
        }
        return collisions;
    }
}
