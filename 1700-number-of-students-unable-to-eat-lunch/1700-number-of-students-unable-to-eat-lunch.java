class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new ArrayDeque<>();
        for(int s: students) q.offer(s);

        int idx=0, rotate=0;

        while(!q.isEmpty() && rotate < q.size()){
            if(q.peek() == sandwiches[idx]){
                q.poll();
                rotate=0;
                idx++;
            } else {
                q.offer(q.poll());
                rotate++;
            }
        }
        return q.size();
    }
}