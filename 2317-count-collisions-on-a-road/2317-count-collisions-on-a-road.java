class Solution {
    public int countCollisions(String directions) {
        Deque<Character> st = new ArrayDeque<>();
        int collisions = 0;

        for (char c : directions.toCharArray()) {
            if (c == 'R') {
                st.push('R');
            } else if (c == 'S') {
                // All pending R's collide into this S
                while (!st.isEmpty() && st.peek() == 'R') {
                    st.pop();
                    collisions += 1;
                }
                st.push('S');
            } else { // c == 'L'
                if (st.isEmpty()) {
                    // Leaves the road, no collision
                    continue;
                }
                if (st.peek() == 'R') {
                    // First R + L -> 2 collisions
                    st.pop();
                    collisions += 2;
                    // Any remaining R's behind will bump into the new S
                    while (!st.isEmpty() && st.peek() == 'R') {
                        st.pop();
                        collisions += 1;
                    }
                    st.push('S');
                } else if (st.peek() == 'S') {
                    // L meets S -> 1 collision, remains S
                    collisions += 1;
                    // Keep a single S on top; no need to push another
                } else {
                    // top is 'L' -> current L also leaves, no collision
                    // do nothing
                }
            }
        }
        return collisions;
    }
}
