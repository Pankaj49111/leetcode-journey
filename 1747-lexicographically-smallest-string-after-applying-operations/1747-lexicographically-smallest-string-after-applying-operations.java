class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();

        String small = s;
        q.offer(s); seen.add(s);

        while(!q.isEmpty()){
            String curr = q.poll();

            if(curr.compareTo(small)<0) small = curr;

            String upd = indi(curr, a);
            if(seen.add(upd)) q.offer(upd);

            String rot = rot(curr, b);
            if(seen.add(rot)) q.offer(rot);
        }
        return small;
    }

    String indi(String curr, int a){
        int i=1;
        char[] arr = curr.toCharArray();
        while(i%2 != 0 && i<arr.length){
            int d = arr[i] - '0';
            arr[i] = (char)('0' + (d+a)%10);
            i+=2;
        }
        return new String(arr);
    }

    String rot(String curr, int b){
        int n = curr.length();
        b %= n;
        return curr.substring(n-b) + curr.substring(0, n-b);
    }
}