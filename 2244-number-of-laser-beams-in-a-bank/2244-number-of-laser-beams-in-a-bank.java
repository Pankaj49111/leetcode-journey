class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> ls = new ArrayList<>();
        for(String b: bank) {
            int count=0;
            for(char c: b.toCharArray()){
                if(c-'0' == 1) count++;
            }
            if(count != 0) ls.add(count);
        }
        int sum = 0;
        if(ls.size() < 2) return sum;

        for(int i=1; i<ls.size(); i++){
            sum += ls.get(i-1)*ls.get(i);
        }
        return sum;
    }
}